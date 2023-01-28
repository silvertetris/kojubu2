package com.kojubu.jabda;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class helpInfo extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        EmbedBuilder helpEmbed = new EmbedBuilder().setTitle("코주부v2 안내")
                .setAuthor("made by CAPYBARA", "https://github.com/silvertetris")
                .setColor(Color.pink).setDescription("음성, 로그 등등 다양한 기능 많음 \n ``/``키를 이용해 명령어 설명을 볼 수 있음");
        String membertag = event.getUser().getAsTag();
        String command = event.getName();

        if (command.equals("help")) {
            event.deferReply().setEphemeral(true).queue();
            event.getHook().sendMessage("DM으로 보냄!").queue();
            event.getMember().getUser().openPrivateChannel().queue(privateChannel ->
            {
                privateChannel.sendMessage("``" + membertag + "님! 도움말 안내입니다!``\n").addEmbeds(helpEmbed.build()).queue();
            });//sendMessageEmbeds needs parameter type messageEmbed meanwhile helpEmbed type is EmbedBuilder
        }
    }
}
