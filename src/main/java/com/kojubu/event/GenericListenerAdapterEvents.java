package com.kojubu.event;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GenericListenerAdapterEvents extends ListenerAdapter {
    int k = 0;
    int HwakMa = 0;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        String guildName = event.getGuild().getName();
        List<TextChannel> FindWelcomeChannel = event.getGuild().getTextChannelsByName("welcome", true);
        List<TextChannel> findLeaveChannel = event.getGuild().getTextChannelsByName("bye", true);

        if (command.equals("set_welcome")) {
            event.deferReply().setEphemeral(true).queue();
            if (!FindWelcomeChannel.isEmpty()) {
                event.getHook().sendMessage("이미 " + FindWelcomeChannel.get(0) + "채널이 있습니다!").queue();
                return;
            }
            event.getHook().sendMessage("환영 채널 생성 완료!").queue();
            event.getGuild().createTextChannel("welcome").queue();
            event.getUser().openPrivateChannel().queue(privateChannel ->
            {
                privateChannel.sendMessage("``" + guildName + "`` 서버에 환영 채널을 생성했어요!").queue();
            });
        }
        if (command.equals("set_leave")) {
            event.deferReply().setEphemeral(true).queue();
            if (!findLeaveChannel.isEmpty()) {
                event.getHook().sendMessage("이미" + findLeaveChannel.get(0) + "채널이 있습니다!").queue();
                return;
            }
            event.getHook().sendMessage("퇴장 채널 생성 완료!").queue();
            event.getGuild().createTextChannel("bye").queue();
            event.getUser().openPrivateChannel().queue(privateChannel ->
            {
                privateChannel.sendMessage("``" + guildName + "`` 서버에 퇴장 채널을 생성했어요!").queue();
            });
        }

    }

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
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        try {
            super.onMessageReceived(event);
            if(event.getGuild().getId().equals("1005135110015832174")) {
                String beakma=event.getJDA().retrieveUserById("866160354455060492").complete().getAsMention();
                if (event.getMessage().getContentRaw().equals("백마")) {
                    HwakMa++;
                    event.getChannel().sendMessage(beakma+" **백마야 모배 그만해**").addContent("\n``적은 횟수: " + HwakMa + "번``").queue();
                    if(HwakMa==100) {
                        event.getMember().getUser().openPrivateChannel().queue(privateChannel ->
                        {privateChannel.sendMessage("``100번째 백마를 부르셨군요! 축하드립니다! 어쩌면 당신은 백마를 좋아할지도??``").queue();});
                    }
                }
            }
            if (event.getMessage().getContentRaw().equals("이동훈")) {
                k++;
                event.getChannel().sendMessage("귀여운 기니피그").addContent("\n``적은 횟수: " + k + "번``").queue();
            }

            if (!event.getMessage().isFromGuild()) {
                return;
            }
            //System.out.println(GuildName + ":" + ChannelName + "\n" + MemberTag + ":" + event.getMessage().getContentDisplay());
        } catch (NullPointerException e) {
           //System.out.println("누군가 봇으로 메세지 보냄!");
        }
    }
}
