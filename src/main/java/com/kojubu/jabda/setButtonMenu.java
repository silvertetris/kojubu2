package com.kojubu.jabda;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.w3c.dom.Text;

import java.util.List;

public class setButtonMenu extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        // 버튼을 포함한 액션 로우 생성
        ActionRow row = ActionRow.of(Button.primary("hello-button", "Hello"));

        // 메시지에 액션 로우 추가
        if (command.equals("set_music_button")) {
            String channel_id=event.getChannel().getId();
            List<TextChannel> findMusicChannel = event.getGuild().getTextChannelsByName("kojubu bot", true);
            try{
                if(!findMusicChannel.isEmpty()) {
                    event.deferReply().setEphemeral(true).queue();
                    event.getHook().sendMessage("이미 있음!"+ findMusicChannel.get(0)).queue();
                    return;
                }
                event.deferReply().setEphemeral(false).queue();
                event.getHook().sendMessage("설정 완료!").queue();
                event.getGuild().createTextChannel("kojubu bot").queue();
                event.getChannel().sendMessage("Click the button").setComponents(row).complete();
            } catch (NullPointerException e1) {
                event.getChannel().sendMessage("서버를 찾을 수 없음!").queue();
            }

        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("hello-button")) {
            event.reply("Hello, " + event.getUser().getAsMention()).queue();
        }
    }
}