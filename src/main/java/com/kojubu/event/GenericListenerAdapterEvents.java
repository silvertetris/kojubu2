package com.kojubu.event;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class GenericListenerAdapterEvents extends ListenerAdapter {
    int k=0;
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {//this Guildevents have to get exact channel, not generic
        String MemberMention = event.getUser().getAsMention();
        List<TextChannel> FindWelcomeChannel = event.getGuild().getTextChannelsByName("welcome", true);
        TextChannel WelcomeChannel = FindWelcomeChannel.get(0);
        String WelcomeMessage = String.format("**반가워요!**, " + MemberMention + "님!");
        WelcomeChannel.sendMessage(WelcomeMessage).queue();
    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        String MemberTag = event.getUser().getAsTag();
        List<TextChannel> FindLeaveChannel = event.getGuild().getTextChannelsByName("bye", true);
        TextChannel LeaveChannel = FindLeaveChannel.get(0);
        String LeaveMessage = String.format("**잘가요 ㅠㅠ**, " + MemberTag + "님!");
        LeaveChannel.sendMessage(LeaveMessage).queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String MemberTag = event.getMember().getUser().getAsTag();
        if (event.getMessage().getContentRaw().equals("이동훈")) {
            k++;
            event.getChannel().sendMessage("귀여운 기니피그").addContent("\n``적은 횟수: " + k + "번``").queue();
        }
        super.onMessageReceived(event);
        System.out.println(MemberTag+":"+event.getMessage().getContentDisplay());
    }
}
