package com.kojubu.event;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.w3c.dom.Text;

import java.util.List;

public class JoinEvent extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        String MemberMention=event.getUser().getAsMention();
        List<TextChannel> FindWelcomeChannel = event.getGuild().getTextChannelsByName("welcome", true);
        TextChannel WelcomeChannel = FindWelcomeChannel.get(0);
        String WelcomeMessage = String.format("**반가워요!**, "+MemberMention+"님!");
        WelcomeChannel.sendMessage(WelcomeMessage).queue();
    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        String MemberTag=event.getUser().getAsTag();
        List<TextChannel> FindLeaveChannel= event.getGuild().getTextChannelsByName("bye", true);
        TextChannel LeaveChannel=FindLeaveChannel.get(0);
        String LeaveMessage=String.format("**잘가요 ㅠㅠ**, "+MemberTag+"님!");
        LeaveChannel.sendMessage(LeaveMessage).queue();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        int k=0;
        if(event.getMessage().equals("이동훈")){
            k++;
            event.getChannel().sendMessage("귀여운 기니피그\n").addContent("``적은 횟수: "+k+"번``").queue();
        }
    }

}
