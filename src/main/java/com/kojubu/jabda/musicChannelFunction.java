package com.kojubu.jabda;

import com.kojubu.LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class musicChannelFunction extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.isFromGuild() && event.getGuild().getTextChannelsByName("kojubu2", true).isEmpty()) {
            return;
        }
        if (!event.getChannel().getName().equals("kojubu2")) {
            return;
        }
        if (event.isFromGuild() && event.getMember().getUser().isBot()) {
            return;
        }

        super.onMessageReceived(event);
        if (!event.getMember().getVoiceState().inAudioChannel()) {
            event.getMessage().getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage("**해당 채널의 기능을 사용하려면 음성 채널에 입장하셔야 합니다.**").queue();
            });
            event.getMessage().delete().queue();
            return;
        }
        if (!event.getGuild().getSelfMember().getVoiceState().inAudioChannel()) {
            event.getGuild().getAudioManager().openAudioConnection(event.getMember().getVoiceState().getChannel());
        }
        String link = event.getMessage().getContentRaw();
        link = " " + link;
        if (!isUrl(link)) {
            link = "ytsearch:" + link /*+ " audio"*/;// find and search video if it is not url
        }
        //GuildMusicManager musicManager = PlayerManager.getINSTANCE().getMusicManager(event.getGuild());
        TextChannel channel = event.getGuild().getTextChannelsByName("kojubu2", true).get(0);
        System.out.println(link);
        event.getMessage().delete().queue();
        List<TextChannel> findMusicChannel = event.getGuild().getTextChannelsByName("kojubu2", true);
        if(!findMusicChannel.isEmpty() && findMusicChannel.get(0).getHistory().retrievePast(1).complete().size()<2) {
            if(findMusicChannel.get(0).getHistory().retrievePast(1).complete().size()<1) {
                event.getMessage().getMember().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessage("**코주부 뮤직 준비가 안되었습니다! 관리자에게 문의하세요!**").queue();
                });
                return;
            }
        }
        //List<Message> messages = event.getChannel().getHistory().retrievePast(100).complete();
        //String id = messages.get(messages.size() - 1).getId();
        PlayerManager.getINSTANCE().loadAndPlay(channel, link);
        /*Queue<AudioTrack> queue = PlayerManager.getINSTANCE().getMusicManager(event.getGuild()).scheduler.queue;
        AudioPlayer audioPlayer = musicManager.audioPlayer;
        AudioTrack currentTrack = audioPlayer.getPlayingTrack();
        if (currentTrack == null) {
            System.out.println("힝");
            return;
        }
        EmbedBuilder musicEmbedUpdate = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.BLUE).addField("현재 곡", currentTrack.getInfo().title, false)
                .addField("아티스트", currentTrack.getInfo().author, false)
                .addField("URL", currentTrack.getInfo().uri, false);
        event.getChannel().editMessageEmbedsById(id, musicEmbedUpdate.build()).queue();
        TrackScheduler scheduler=musicManager.scheduler;
        scheduler.onTrackStart(musicManager.audioPlayer, currentTrack);*/
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

