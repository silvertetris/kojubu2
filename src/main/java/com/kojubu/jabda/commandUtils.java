package com.kojubu.jabda;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Objects;

public class commandUtils extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("삭제")) {
            if(event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                int messageIndex = event.getOption("purge_amount").getAsInt();
                List<Message> messages = event.getChannel().getHistory().retrievePast(messageIndex).complete();
                event.deferReply().setEphemeral(true).queue();
                event.getChannel().purgeMessages(messages);
                event.getHook().sendMessage("삭제 완료!").queue();
            } else {
                event.deferReply().setEphemeral(true).queue();
                event.getHook().sendMessage("이 명령어를 사용할 권한이 없습니다!").queue();
            }
        }
    }
}
