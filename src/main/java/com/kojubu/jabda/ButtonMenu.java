package com.kojubu.jabda;

import com.kojubu.LavaPlayer.GuildMusicManager;
import com.kojubu.LavaPlayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.List;
import java.util.Queue;

public class ButtonMenu extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        boolean checkAdmin = event.getMember().hasPermission(Permission.ADMINISTRATOR);
        List<Role> userRoles = event.getMember().getRoles();
        String command = event.getName();
        Button playbutton = Button.primary("play_pause", Emoji.fromUnicode("U+23EF"));
        Button stopbutton = Button.danger("stop_button", Emoji.fromUnicode("U+23F9"));
        Button skipbutton = Button.primary("skip_button", Emoji.fromUnicode("U+23ED"));
        ActionRow row = ActionRow.of(playbutton, skipbutton, stopbutton);
        EmbedBuilder musicEmbedInit = new EmbedBuilder().setTitle("코주부 뮤직")
                .setDescription("버튼을 누르세요!")
                .setColor(Color.green);

        if (checkAdmin) {
            if (command.equals("set_music_button") && checkAdmin) {
                try {
                    List<TextChannel> findMusicChannel = event.getGuild().getTextChannelsByName("kojubu2", true);
                    if (!findMusicChannel.isEmpty()) {
                        event.deferReply().setEphemeral(true).queue();
                        event.getHook().sendMessage("이미 있음!" + findMusicChannel.get(0)).queue();
                        return;
                    }
                    event.deferReply().setEphemeral(false).queue();
                    event.getGuild().createTextChannel("kojubu2").complete().sendMessageEmbeds(musicEmbedInit.build()).setComponents(row)
                            .queue();
                    event.getHook().sendMessage("설정 완료!").queue();
                } catch (NullPointerException e1) {
                    event.getChannel().sendMessage("서버를 찾을 수 없음!").queue();
                }

            }
        } else {
            event.deferReply().setEphemeral(true).queue();
            event.getHook().sendMessage("이 명령어를 실행할 권한이 없습니다!").queue();
        }
    }
    public void updateMusicEmbed(MessageChannel channel, AudioTrack currentTrack) {
        EmbedBuilder musicEmbedUpdate = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.BLUE).addField("현재 곡", currentTrack.getInfo().title, false)
                .addField("아티스트", currentTrack.getInfo().author, false)
                .addField("URL", currentTrack.getInfo().uri, false);
        List<Message> messages = channel.getHistory().retrievePast(100).complete();
        String id = messages.get(messages.size() - 1).getId();
        channel.editMessageEmbedsById(id, musicEmbedUpdate.build()).queue();
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        GuildMusicManager musicManager = PlayerManager.getINSTANCE().getMusicManager(event.getGuild());
        if (event.getComponentId().equals("play_pause")) {
            if (!musicManager.scheduler.audioPlayer.isPaused()) {
                musicManager.scheduler.audioPlayer.setPaused(true);
            } else {
                musicManager.scheduler.audioPlayer.setPaused(false);
            }
        } else if (event.getComponentId().equals("stop_button")) {
            musicManager.scheduler.queue.clear();
            musicManager.scheduler.audioPlayer.stopTrack();
            musicManager.scheduler.audioPlayer.setPaused(false);
        } else if (event.getComponentId().equals("skip_button")) {
            musicManager.scheduler.nextTrack();
        }
        event.deferEdit().queue();
    }
}