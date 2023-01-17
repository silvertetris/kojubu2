package com.kojubu.LavaPlayer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

public class TrackScheduler extends AudioEventAdapter {

    public final AudioPlayer audioPlayer;
    public final BlockingQueue<AudioTrack> queue;
    public boolean repeating=false;

    public TrackScheduler(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void queue(AudioTrack track) {
        if (!this.audioPlayer.startTrack(track, true))
            this.queue.offer(track);
    }
    public void nextTrack() {
        try
        {
            AudioTrack nextTrack=this.queue.poll();
            /*if(nextTrack == null) {
                return;
            }*/
            this.audioPlayer.startTrack(nextTrack, false);
        }
        catch (Exception e1)
        {
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
        super.onTrackStart(player, track);
    }

    @Override
    public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
        if(endReason.mayStartNext) {
            if(this.repeating) {
                this.audioPlayer.startTrack(track.makeClone(), false);
                return;
            }
            nextTrack();
        }
    }
}
