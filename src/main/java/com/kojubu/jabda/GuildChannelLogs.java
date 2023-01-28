package com.kojubu.jabda;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class GuildChannelLogs extends ListenerAdapter {
    public void LogChannelSetupSlashCommand(SlashCommandInteractionEvent event) {
        String MemberTag = event.getMember().getUser().getAsTag();
        String MemberMention = event.getMember().getAsMention();
        String GuildName=event.getGuild().getName();
        String Command= event.getName();
        List<TextChannel> FindLogsChannel = event.getGuild().getTextChannelsByName("logs", true);
        TextChannel LogsChannel = FindLogsChannel.get(0);

        if(Command.equals("SetLog")){
            if(!(LogsChannel ==null)){
                event.deferReply().setEphemeral(true).queue();
                event.getHook().sendMessage("**이미"+LogsChannel+"채널이 있습니다!**").queue();
            }
            else {
                event.getGuild().createTextChannel("logs").queue();
                event.getMember().getUser().openPrivateChannel()
                        .queue(privateChannel -> {privateChannel.sendMessage("``"+GuildName+"`` 서버에 logs 채널을 생성했어요!").queue();});
            }
        }
}
    public void ShowLogs(MessageReceivedEvent event) {
        try{
            String message = event.getMessage().getContentRaw();
            String member=event.getMessage().getAuthor().getAsTag();
            if(event.getGuild().getTextChannelsByName("logs", true).get(0).equals("logs")) return;

            event.getGuild().getTextChannelsByName("logs", true).get(0).sendMessage(message+member).queue();
        } catch (NullPointerException e) {

        }

    }

}
