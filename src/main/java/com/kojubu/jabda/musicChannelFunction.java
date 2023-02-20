package com.kojubu.jabda;

import com.kojubu.LavaPlayer.GuildMusicManager;
import com.kojubu.LavaPlayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.w3c.dom.Text;

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
        link=" "+link;
        if (!isUrl(link)) {
            link = "ytsearch:" + link + " audio";// find and search video if it is not url
        }
        TextChannel channel = event.getGuild().getTextChannelsByName("kojubu2", true).get(0);
        System.out.println(link);
        event.getMessage().delete().queue();
        PlayerManager.getINSTANCE().loadAndPlay(channel, link);
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

