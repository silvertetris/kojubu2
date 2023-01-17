package com.kojubu.event;

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        int k;
        String currentchannelname= event.getChannel().getName();
        MessageChannelUnion Channel = event.getChannel();
        super.onMessageReceived(event);
    }

}
