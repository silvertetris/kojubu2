package com.kojubu.jabda;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class IsviableSecondCommandsTEST extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        EmbedBuilder helpEmbed = new EmbedBuilder().setTitle("코주부v2 안내").setAuthor("made by CAPYBARA", "https://github.com/silvertetris").setColor(Color.pink).
                setDescription("asdfasdfasdf!!@!#!");
        String membertag = event.getUser().getAsTag();
        String command = event.getName();

        if (command.equals("help")) {
            event.deferReply().setEphemeral(true).queue();
            event.getHook().sendMessage("``" + membertag + "님! 도움말 안내입니다!``\n").addEmbeds(helpEmbed.build()).queue();
            //sendMessageEmbeds needs parameter type messageEmbed meanwhile helpEmbed type is EmbedBuilder
        }
    }
}
