package com.kojubu.LavaPlayer;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {
    private static PlayerManager INSTANCE;
    private final Map<Long, GuildMusicManager> musicManagers;
    private final AudioPlayerManager audioPlayerManager;

    public PlayerManager() {
        this.musicManagers = new HashMap<>();
        this.audioPlayerManager = new DefaultAudioPlayerManager();

        AudioSourceManagers.registerRemoteSources(this.audioPlayerManager);
        AudioSourceManagers.registerLocalSource(this.audioPlayerManager);
    }

    public static PlayerManager getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerManager();
        }
        return INSTANCE;
    }


    public GuildMusicManager getMusicManager(Guild guild) {
        return this.musicManagers.computeIfAbsent(guild.getIdLong(), (guildID) -> {
            final GuildMusicManager guildMusicManager = new GuildMusicManager(this.audioPlayerManager, guild);
            guild.getAudioManager().setSendingHandler(guildMusicManager.getSendHandler());
            return guildMusicManager;
        });
    }

    public void loadAndPlay(TextChannel textChannel, String trackURL) {
        final GuildMusicManager musicManager = this.getMusicManager(textChannel.getGuild());

        this.audioPlayerManager.loadItemOrdered(musicManager, trackURL, new AudioLoadResultHandler() {

            @Override
            public void loadFailed(FriendlyException arg0) {
                textChannel.sendMessage("?????? ??????! ?????? ??????????????????!").queue();
            }

            @Override
            public void noMatches() {
                textChannel.sendMessage("?????? ?????? ??????!").queue();
            }

            @Override
            public void playlistLoaded(AudioPlaylist audioPlaylist) {
                final List<AudioTrack> tracks = audioPlaylist.getTracks();
                if (!tracks.isEmpty()) {
                    if(textChannel.getName().equals("kojubu2")){
                        musicManager.scheduler.queue(tracks.get(0));
                        List<Message> messages = textChannel.getManager().getChannel().getHistory().retrievePast(100).complete();
                        String id = messages.get(messages.size() - 1).getId();
                        EmbedBuilder musicEmbedUpdate = new EmbedBuilder().setTitle("????????? ??????").setColor(Color.BLUE)
                                .addField("????????? ??????", audioPlaylist.getTracks().get(0).getInfo().title, false)
                                .addField("????????????", audioPlaylist.getTracks().get(0).getInfo().author, false)
                                .addField("URL", audioPlaylist.getTracks().get(0).getInfo().uri, false);
                        textChannel.editMessageEmbedsById(id, musicEmbedUpdate.build()).queue();
                        if (textChannel.getManager().getChannel().getHistory().retrievePast(100).complete().get(0) == null) {
                            System.out.println("???");
                        }
                        return;
                    }
                    musicManager.scheduler.queue(tracks.get(0));
                    textChannel
                            .sendMessage("????????? ????????? **`" + tracks.get(0).getInfo().title + "`** by **`"
                                    + tracks.get(0).getInfo().author
                                    + "`**")
                            .queue();
                }
            }

            @Override
            public void trackLoaded(AudioTrack audioTrack) {
                if(textChannel.getName().equals("kojubu2")) {
                    musicManager.scheduler.queue(audioTrack);

                }
                musicManager.scheduler.queue(audioTrack);
                textChannel.sendMessage(
                                "????????? ????????? **`" + audioTrack.getInfo().title + "`** by **`" + audioTrack.getInfo().author + "`**")
                        .queue();
            }

        });
    }
}