package com.kojubu.LavaPlayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.awt.*;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TrackScheduler extends AudioEventAdapter {

    public final AudioPlayer audioPlayer;
    public final BlockingQueue<AudioTrack> queue;
    public boolean repeating = false;
    public TextChannel textChannel;


    public TrackScheduler(AudioPlayer audioPlayer, TextChannel textChannel) {
        this.audioPlayer = audioPlayer;
        this.queue = new LinkedBlockingQueue<>();
        this.textChannel= textChannel;
    }

    public void queue(AudioTrack track) {
        if (!this.audioPlayer.startTrack(track, true))
            this.queue.offer(track);
    }

    public void nextTrack() {
        try {
            AudioTrack nextTrack = this.queue.poll();
            /*if(nextTrack == null) {
                return;
            }*/
            this.audioPlayer.startTrack(nextTrack, false);
        } catch (Exception e1) {
            System.out.println("Error occurred skipping");
        }

    }

    @Override
    public void onPlayerPause(AudioPlayer player) {
        super.onPlayerPause(player);
    }

    @Override
    public void onPlayerResume(AudioPlayer player) {
        super.onPlayerResume(player);
    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        //super.onTrackStart(player, track);
        /*if (textChannel.getGuild().getName().equals("kojubu2")) {
            List<Message> messages = textChannel.getManager().getChannel().getHistory().retrievePast(100).complete();
            String id = messages.get(messages.size() - 1).getId();
            AudioTrack currentTrack = player.getPlayingTrack();
            EmbedBuilder musicEmbedUpdate = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.BLUE).addField("현재 곡", currentTrack.getInfo().title, false)
                    .addField("아티스트", currentTrack.getInfo().author, false)
                    .addField("URL", currentTrack.getInfo().uri, false);
            textChannel.editMessageEmbedsById(id, musicEmbedUpdate.build()).queue();
            if(textChannel.getManager().getChannel().getHistory().retrievePast(100).complete().get(0)==null) {
                System.out.println("헹");
            } else {
                System.out.println(messages.get(0));
            }
        }
        System.out.println("후헹");*/
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        if (endReason.mayStartNext) {
            if (this.repeating) {
                this.audioPlayer.startTrack(track.makeClone(), false);
                return;
            }
            nextTrack();

        }
    }
}
