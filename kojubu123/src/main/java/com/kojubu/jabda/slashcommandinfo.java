package com.kojubu.jabda;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class slashcommandinfo extends ListenerAdapter {
    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> CommandData = new ArrayList<>();
        CommandData.add(Commands.slash("환영", "환영함"));
        CommandData.add(Commands.slash("역할", "역할 뭐 있는지 알려줌"));
        CommandData.add(Commands.slash("레이드", "레이드파티"));
        CommandData.add(Commands.slash("connect", "음성 채널에 연결"));
        OptionData urlData = new OptionData(OptionType.STRING, "url", "링크나 제목", true);
        CommandData.add(Commands.slash("play", "노래재생").addOptions(urlData));
        CommandData.add(Commands.slash("queue", "재생목록"));
        CommandData.add(Commands.slash("stop", "멈추고, 목록 클리어"));
        CommandData.add(Commands.slash("skip", "노래스킵"));
        CommandData.add(Commands.slash("leave", "연결끊기"));
        CommandData.add(Commands.slash("np", "재생 중인 노래"));
        CommandData.add(Commands.slash("pause", "노래 일시정지!"));
        CommandData.add(Commands.slash("resume", "노래 재개"));
        CommandData.add(Commands.slash("volume_status", "현재 음량 크기"));
        OptionData volumeData = new OptionData(OptionType.INTEGER, "set_volume", "숫자", true).setRequiredRange(1
        , 100);
        CommandData.add(Commands.slash("volume", "소리 크기 조절").addOptions(volumeData));
        CommandData.add(Commands.slash("repeat", "반복"));
        event.getGuild().updateCommands().addCommands(CommandData).queue();
        event.getJDA().updateCommands().addCommands(CommandData).queue();
    }
}
