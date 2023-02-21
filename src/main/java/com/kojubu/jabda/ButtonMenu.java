package com.kojubu.jabda;

import com.kojubu.LavaPlayer.GuildMusicManager;
import com.kojubu.LavaPlayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonMenu extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        boolean checkAdmin = event.getMember().hasPermission(Permission.ADMINISTRATOR);
        List<Role> userRoles = event.getMember().getRoles();
        String command = event.getName();
        Button playbutton = Button.primary("play_pause", Emoji.fromUnicode("U+23EF"));
        Button stopbutton = Button.danger("stop_button", Emoji.fromUnicode("U+23F9"));
        Button skipbutton = Button.primary("skip_button", Emoji.fromUnicode("U+23ED"));
        Button npbutton = Button.secondary("np_button", Emoji.fromUnicode("U+1F3B5"));
        Button queuebutton = Button.secondary("queue_button", Emoji.fromUnicode("U+1F4C4"));
        ActionRow row = ActionRow.of(playbutton, skipbutton, stopbutton, npbutton, queuebutton);
        EmbedBuilder musicEmbedInit = new EmbedBuilder().setTitle("코주부 뮤직")
                .setDescription("버튼을 누르세요!")
                .setColor(Color.green);
        if (command.equals("set_music_button") && checkAdmin) {
            try {
                List<TextChannel> findMusicChannel = event.getGuild().getTextChannelsByName("kojubu2", true);
                if (!findMusicChannel.isEmpty()) {
                    event.deferReply().setEphemeral(true).queue();
                    event.getHook().sendMessage("이미 있음!" + findMusicChannel.get(0)).queue();
                    return;
                }
                /*if (findMusicChannel.get(0).getHistory().retrievePast(1).complete().isEmpty()) {
                    event.getChannel().sendMessageEmbeds(musicEmbedInit.build()).setComponents(row).queue();
                    event.deferReply().setEphemeral(true).queue();
                    event.getHook().sendMessage("설정 완료!").queue();
                    return;
                }*/
                event.deferReply().setEphemeral(false).queue();
                event.getGuild().createTextChannel("kojubu2").complete().sendMessageEmbeds(musicEmbedInit.build()).setComponents(row)
                        .queue();
                event.getHook().sendMessage("설정 완료!").queue();
            } catch (NullPointerException e1) {
                event.getChannel().sendMessage("서버를 찾을 수 없음!").queue();
            } catch (PermissionException e2) {
                event.deferReply().setEphemeral(true).queue();
                event.getHook().sendMessage("**이 명령어를 실행할 권한이 없습니다!**").queue();
            } catch (IndexOutOfBoundsException e3) {
                System.out.println("힝...");
            }
        }
        if(command.equals("button_init")) {

        }
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
        } else if (event.getComponentId().equals("np_button")) {
            List<Message> messages = event.getChannel().getHistory().retrievePast(100).complete();
            String id = messages.get(messages.size() - 1).getId();
            if (musicManager.audioPlayer.getPlayingTrack() == null) {
                EmbedBuilder ifnullmessage = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.red)
                        .addField("현재 노래", "현재 재생 되고 있는 노래가 없거나 잠시 후에 다시 시도해 주세요!", false);
                event.getChannel().editMessageEmbedsById(id, ifnullmessage.build()).queue();
            }
            EmbedBuilder musicEmbedUpdate = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.BLUE)
                    .addField("현재 노래", musicManager.audioPlayer.getPlayingTrack().getInfo().title, false)
                    .addField("아티스트", musicManager.audioPlayer.getPlayingTrack().getInfo().author, false)
                    .addField("URL", musicManager.audioPlayer.getPlayingTrack().getInfo().uri, false);
            event.getChannel().editMessageEmbedsById(id, musicEmbedUpdate.build()).queue();
            if (event.getChannel().getHistory().retrievePast(100).complete().get(0) == null) {
                System.out.println("헹");
            }
        } else if (event.getComponentId().equals("queue_button")) {
            List<Message> messages = event.getChannel().getHistory().retrievePast(100).complete();
            String id = messages.get(messages.size() - 1).getId();
            if (musicManager.scheduler.queue.isEmpty()) {
                EmbedBuilder emptyqueue_message = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.red)
                        .addField("목록", "**목록이 비어있어요!**", false);
                event.getChannel().editMessageEmbedsById(id, emptyqueue_message.build()).queue();
            } else {
                int i = 0;
                List<AudioTrack> trackList = new ArrayList<>(musicManager.scheduler.queue);
                int trackCount = Math.min(musicManager.scheduler.queue.size(), 20);
                StringBuilder list = new StringBuilder();
                for (i = 0; i < trackCount; i++) {
                    AudioTrack track = trackList.get(i);
                    AudioTrackInfo info = track.getInfo();
                    list.append("#").append(i + 1)
                            .append(".**` ").append(info.title)
                            .append("`** - ").append(info.author).append("**링크: **")
                            .append(info.uri).append("\n");
                }
                String queueList = list.toString();
                EmbedBuilder queueUpdate = new EmbedBuilder().setTitle("코주부 뮤직").setColor(Color.BLACK)
                        .addField("목록", queueList, false);
                event.getChannel().editMessageEmbedsById(id, queueUpdate.build()).queue();
            }
        }
        event.deferEdit().queue();
    }
}