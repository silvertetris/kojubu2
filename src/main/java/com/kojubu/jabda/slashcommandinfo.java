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
        List<CommandData> GuildCommandData = new ArrayList<>();
        List<CommandData> JDACommandData=new ArrayList<>();
        JDACommandData.add(Commands.slash("환영", "환영함"));
        GuildCommandData.add(Commands.slash("역할", "역할 뭐 있는지 알려줌"));
        GuildCommandData.add(Commands.slash("레이드", "레이드파티"));
        GuildCommandData.add(Commands.slash("connect", "음성 채널에 연결"));
        OptionData urlData = new OptionData(OptionType.STRING, "url", "링크나 제목", true);
        GuildCommandData.add(Commands.slash("play", "노래재생").addOptions(urlData));
        GuildCommandData.add(Commands.slash("queue", "재생목록"));
        GuildCommandData.add(Commands.slash("stop", "멈추고, 목록 클리어"));
        GuildCommandData.add(Commands.slash("skip", "노래스킵"));
        GuildCommandData.add(Commands.slash("leave", "연결끊기"));
        GuildCommandData.add(Commands.slash("np", "재생 중인 노래"));
        GuildCommandData.add(Commands.slash("pause", "노래 일시정지!"));
        GuildCommandData.add(Commands.slash("resume", "노래 재개"));
        GuildCommandData.add(Commands.slash("volume_status", "현재 음량 크기"));
        OptionData volumeData = new OptionData(OptionType.INTEGER, "set_volume", "숫자", true).setRequiredRange(1
        , 100);
        GuildCommandData.add(Commands.slash("volume", "소리 크기 조절").addOptions(volumeData));
        GuildCommandData.add(Commands.slash("repeat", "반복"));
        GuildCommandData.add(Commands.slash("set_log", "로그 채널 생성"));
        GuildCommandData.add(Commands.slash("set_welcome", "환영 채널 생성"));
        GuildCommandData.add(Commands.slash("set_leave", "퇴장 채널 생성"));
        GuildCommandData.add(Commands.slash("set_music_button", "버튼메세지 생성"));
        OptionData purgeAmountData=new OptionData(OptionType.INTEGER, "purge_amount", "삭제할 메세지 수", true).setRequiredRange(1,20);
        GuildCommandData.add(Commands.slash("삭제", "메세지 삭제").addOptions(purgeAmountData));
        JDACommandData.add(Commands.slash("엘소드_시너지", "엘소드 캐릭터 시너지 정보"));
        JDACommandData.add(Commands.slash("help", "도움, 설명"));
        event.getGuild().updateCommands().addCommands(GuildCommandData).queue();
        event.getJDA().updateCommands().addCommands(JDACommandData).queue();
    }
}
