package com.kojubu.jabda;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.Instant;
import java.util.List;

public class GuildChannelLogs extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String MemberTag = event.getMember().getUser().getAsTag();
        String MemberMention = event.getMember().getAsMention();
        String GuildName = event.getGuild().getName();
        String Command = event.getName();
        List<TextChannel> FindLogsChannel = event.getGuild().getTextChannelsByName("logs", true);

        if (Command.equals("set_log")) {
            event.deferReply().setEphemeral(true).queue();
            if (!event.getGuild().getTextChannelsByName("logs", true).isEmpty()) {
                TextChannel LogsChannel = FindLogsChannel.get(0);
                event.getHook().sendMessage("**이미" + LogsChannel + "채널이 있습니다!**").queue();
                return;
            }
            event.getHook().sendMessage("생성 완료!").queue();
            event.getGuild().createTextChannel("logs").queue();
            event.getMember().getUser().openPrivateChannel()
                    .queue(privateChannel ->
                    {
                        privateChannel.sendMessage("``" + GuildName + "`` 서버에 logs 채널을 생성했어요!").queue();
                    });

        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        try {
            if (event.getMessage().getChannel().getName().equals("logs")) return;

            String ChannelId = event.getChannel().getId();
            String member = event.getMessage().getAuthor().getAsTag();
            String message = event.getMessage().getContentRaw();
            String messageId = event.getMessageId();
            String jumpurl = event.getMessage().getJumpUrl();
            EmbedBuilder log = new EmbedBuilder()
                    .setTimestamp(Instant.now())
                    .setColor(Color.green)
                    .setTitle("메세지 로그")
                    .addField("채널", "<#" + ChannelId + ">", false)
                    .addField("적은 사람", member, false)
                    .addField("내용", message, false)
                    .addField("메세지 ID", messageId, false)
                    .addField("URL", jumpurl, false);
            event.getGuild().getTextChannelsByName("logs", true).get(0).sendMessageEmbeds(log.build()).queue();
            log.clear();
        } catch (NullPointerException | IndexOutOfBoundsException e) {

        }
    }
}
