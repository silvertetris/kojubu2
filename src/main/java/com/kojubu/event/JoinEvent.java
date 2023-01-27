package com.kojubu.event;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class JoinEvent extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String MemberMention=event.getUser().getAsMention();
        final List<TextChannel> FindWelcomeChannel = event.getGuild().getTextChannelsByName("welcome", true);
        TextChannel WelcomeChannel = FindWelcomeChannel.get(0);
        String WelcomeMessage = String.format("**반가워요!**, "+MemberMention+"님!");
        WelcomeChannel.sendMessage(WelcomeMessage).queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        int k=0;
        if(event.getMessage().equals("이동훈")){
            k++;
            event.getChannel().sendMessage("귀여운 기니피그\n").addContent("적은 횟수"+k).queue();
        }
    }

}
