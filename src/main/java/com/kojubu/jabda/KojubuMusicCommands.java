package com.kojubu.jabda;

import com.kojubu.LavaPlayer.GuildMusicManager;
import com.kojubu.LavaPlayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.managers.AudioManager;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class KojubuMusicCommands extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        final AudioManager audioManager = event.getGuild().getAudioManager();
        final VoiceChannel memberchannel = (VoiceChannel) event.getMember().getVoiceState().getChannel();
        String command = event.getName();
        String userTag = event.getUser().getAsTag();
        String channeltag = event.getChannel().getAsMention();
        String link = String.join(" ", event.getCommandString());
        ReplyCallbackAction ephemeral_true = event.deferReply().setEphemeral(true);
        ReplyCallbackAction ephemeral_false = event.deferReply().setEphemeral(false);
        InteractionHook get_Hook = event.getHook();
        GuildMusicManager musicManager = PlayerManager.getINSTANCE().getMusicManager(event.getGuild());

        if (command.equals("??????")) {
            event.reply("Welcome! " + userTag).queue();
        }

        if (command.equals("??????")) {
            ephemeral_true.queue();
            String response = "";
            for (Role role : event.getGuild().getRoles()) {
                response += role.getAsMention() + "\n";
            }
            get_Hook.sendMessage(response).queue();
        }

        if (command.equals("connect")) {
            ephemeral_true.queue();
            if (!event.getMember().getVoiceState().inAudioChannel()) {
                get_Hook.sendMessage("?????? ????????? ???????????????!").queue();
                return;
            } else if (!event.getGuild().getSelfMember().getVoiceState().inAudioChannel()) {
                audioManager.openAudioConnection(memberchannel);
                get_Hook.sendMessage(channeltag + "??? ?????????!").queue();
            } else {
                get_Hook.sendMessage("?????? ??????????????? ???????????????!").queue();
            }
        }

        if (command.equals("play")) {
            ephemeral_true.queue();
            if (!event.getMember().getVoiceState().inAudioChannel()) {
                get_Hook.sendMessage("?????? ????????? ???????????????!").queue();
                return;
            }
            if (!event.getGuild().getSelfMember().getVoiceState().inAudioChannel()) {
                audioManager.openAudioConnection(memberchannel);
                get_Hook.sendMessage("?????? ?????? ?????????!").queue();
            }
            if (!isUrl(link)) {
                link = "ytsearch:" + link + " audio";// find and search video if it is not url
            }
            get_Hook.sendMessage("?????????!").queue();
            PlayerManager.getINSTANCE().loadAndPlay((TextChannel) event.getChannel(), link);
        }

        if (command.equals("leave")) {
            if (event.getGuild().getSelfMember().getVoiceState().inAudioChannel()) {
                audioManager.closeAudioConnection();
                ephemeral_true.queue();
                get_Hook.sendMessage("??? ??????!").queue();
                return;
            } else {
                ephemeral_true.queue();
                get_Hook.sendMessage("?????? ??????!").queue();
            }
        }

        if (command.equals("stop") && event.getMember().getVoiceState().inAudioChannel()) {
            musicManager.scheduler.audioPlayer.stopTrack();
            musicManager.scheduler.queue.clear();
            ephemeral_true.queue();
            get_Hook.sendMessage("??????!").queue();
            return;
        }

        if (command.equals("skip") && event.getMember().getVoiceState().inAudioChannel()) {
            AudioPlayer audioPlayer = musicManager.audioPlayer;
            AudioTrack track = audioPlayer.getPlayingTrack();
            ephemeral_true.queue();
            if (track == null) {
                get_Hook.sendMessage("?????? ???????????? ????????? ??????!").queue();
                return;
            } else if (!event.getMember().getVoiceState().inAudioChannel()) {
                get_Hook.sendMessage("?????? ????????? ???????????????!").queue();
            } else {
                musicManager.scheduler.nextTrack();
                get_Hook.sendMessage("skipped!").queue();
            }
        }

        if (command.equals("np")) {
            AudioPlayer audioPlayer = musicManager.audioPlayer;
            AudioTrack track = audioPlayer.getPlayingTrack();
            ephemeral_false.queue();
            if (track == null) {
                ephemeral_true.queue();
                get_Hook.sendMessage("?????? ?????? ?????? ????????????!").queue();
                return;
            }
            AudioTrackInfo info = track.getInfo();
            get_Hook.sendMessageFormat("?????? ???: `%s` by `%s` (??????: <%s>)", info.title, info.author, info.uri).queue();
        }

        if (command.equals("queue")) {
            BlockingQueue<AudioTrack> queue = musicManager.scheduler.queue;
            WebhookMessageCreateAction messageAction = get_Hook.sendMessage("**?????? ??????:**\n");
            ephemeral_false.queue();
            int i;
            if (queue.isEmpty()) {
                get_Hook.sendMessage("????????? ?????????!").queue();
            }
            int trackCount = Math.min(queue.size(), 20);
            List<AudioTrack> trackList = new ArrayList<>(queue);
            for (i = 0; i < trackCount; i++) {
                AudioTrack track = trackList.get(i);
                AudioTrackInfo info = track.getInfo();
                messageAction.addContent("#")
                        .addContent(String.valueOf(i + 1))
                        .addContent("``")
                        .addContent(info.title)
                        .addContent("by")
                        .addContent(info.author)
                        .addContent("[")
                        .addContent(formatTime(track.getDuration()))
                        .addContent("]``\n");
            }
            if (trackList.size() > trackCount) {
                messageAction.addContent("And `")
                        .addContent(String.valueOf(trackList.size() - trackCount))
                        .addContent("`more...");
            }
            messageAction.queue();
        }

        if(command.equals("pause")) {
            ephemeral_true.queue();
            musicManager.scheduler.audioPlayer.setPaused(true);
            get_Hook.sendMessage("????????????!").queue();
        }

        if(command.equals("resume"))  {
            ephemeral_true.queue();
            musicManager.scheduler.audioPlayer.setPaused(false);
            get_Hook.sendMessage("?????? ??????!").queue();
        }

        if(command.equals("volume_status")) {
            ephemeral_true.queue();
            int volume = musicManager.scheduler.audioPlayer.getVolume();
            get_Hook.sendMessageFormat("?????? ?????? ??????: %d", volume).queue();
        }

        if(command.equals("volume")) {
            ephemeral_true.queue();
            OptionMapping option=event.getOption("set_volume");
            long setvolume= Objects.requireNonNull(option).getAsLong();
            musicManager.scheduler.audioPlayer.setVolume((int) setvolume);
            get_Hook.sendMessageFormat("?????? ?????? ??????: %d", setvolume).queue();
        }

        if(command.equals("repeat")) {
            boolean new_repeating= !musicManager.scheduler.repeating;
            musicManager.scheduler.repeating=new_repeating;
            ephemeral_true.queue();
            get_Hook.sendMessageFormat("?????? **%s**", new_repeating ? "??????" : "??????").queue();
        }
    }

    private String formatTime(long duration) {
        final long hours = duration / TimeUnit.HOURS.toMillis(1);
        final long minutes = duration / TimeUnit.MINUTES.toMillis(1);
        final long seconds = duration / TimeUnit.SECONDS.toMillis(1);

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


    public boolean isUrl(String url) {
        try {
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}