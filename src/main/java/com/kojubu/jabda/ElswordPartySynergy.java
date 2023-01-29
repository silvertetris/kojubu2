package com.kojubu.jabda;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.awt.*;

public class ElswordPartySynergy extends ListenerAdapter{
    EmbedBuilder elsword_knight_emperor = new EmbedBuilder().setTitle("**나이트 엠퍼러 (나엠)**")
            .setAuthor("엘소드 1라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069169393780658246/EB8298EC9DB4ED8AB8_EC97A0ED8DBCEB9FAC.png?width=634&height=473")
            .setColor(Color.red)
            .setDescription("""
                        ``극기 (극기 - 갑)`` - **12초간 받는 피해 감소 20% 및 슈퍼아머**
                        ``아머 브레이크`` - **7초간 물리 방어력 감소 30%**
                        ``[체인지]아머 브레이크`` - **7초간 물리 방어력 감소 50%, 14초간 피격 대상 공격력 z증가 20%**
                        ``그랜드 크로스`` - **10초간 모든 방어력 감소 20%**
                        ``집념`` - **5초간 물리 방어력 20% 감소**""");

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("elsword_synergy")) return;

        StringSelectMenu character = StringSelectMenu.create("menu:character")
                .setPlaceholder("캐릭터 선택") // shows the placeholder indicating what this menu is for
                .setRequiredRange(1, 1) // exactly one must be selected
                .addOption("엘소드", "Elsword")
                .addOption("아이샤", "Aisha")
                .addOption("레나", "Rena")
                .addOption("레이븐", "Raven")
                .addOption("이브", "Eve")
                .addOption("청", "Chung")
                .addOption("아라", "Ara")
                .addOption("엘리시스", "Elesis")
                .addOption("에드", "Add")
                .addOption("루시엘", "Lu_Ciel")
                .addOption("로제", "Rose")
                .addOption("아인", "Ain")
                .addOption("라비", "Laby")
                .addOption("노아", "Noah")
                .build();

        event.reply("``캐릭터를 선택하세요!``")
                .setEphemeral(true)
                .addActionRow(character)
                .queue();
    }

    @Override
    public void onGenericSelectMenuInteraction(GenericSelectMenuInteractionEvent event) {
        StringSelectMenu lane1= StringSelectMenu.create("menu:elsword")
                .setPlaceholder("라인 선택")
                .setRequiredRange(1, 1)
                .addOption("나이트 엠퍼러", "knight_emperor")
                .addOption("룬 마스터", "rune_master")
                .addOption("임모탈", "immortal")
                .addOption("제네시스", "genesis")
                .build();

        if(event.getComponentId().equals("menu:character")) {
            if(event.getValues().get(0).equals("Elsword")){
                event.deferReply().setEphemeral(true).addActionRow(lane1).queue();
            }
        }
        if(event.getComponentId().equals("menu:elsword")) { //elsword
            event.deferReply().setEphemeral(true).queue();
            if(event.getValues().get(0).equals("knight_emperor"))
            {
                event.getHook().sendMessageEmbeds(elsword_knight_emperor.build()).queue();
            }
            if(event.getValues().get(0).equals("rune_master")) {
                event.getHook().sendMessage("""
                        ``피닉스 탤런`` - **9.75초간 이동속도 10%, 매 초 MP 1.5 회복**
                        ``룬의 영역`` - **10초간 영역 내 아군의 마법 공격력 증가 5%, 10초간 [룬의 각인] 디버프 대상이 받는 마법 피해 증가 5%**
                        ``[체인지]루나 블레이드`` - **7초간 모든 속성 저항 감소 50**
                        ``인챈트 브레이크`` - **5초간 모든 속성 저항 감소 130**
                        ``마력의 사슬`` - **10초간 마법 방어력 감소 12%**
                        ``윈드 블레이드, 라이징 슬래시, 스톰 블레이드 (마력의 흐름)`` - **10초간 모든 속성 저항 감소 30 * 3**""").queue();
            }
            if(event.getValues().get(0).equals("immortal")) {
                event.getHook().sendMessage("""
                        ``콘웰을 사용하는 스킬 (전투의 달인)`` - **5초간 받는 피해 증가 10%**
                        ``[체인지] 인피니티 체이서`` - **약 4초간 범위 내 아군의 공격력 증가 10%, 이동속도 증가 30%**
                        """).queue();
            }
            if(event.getValues().get(0).equals("genesis")) {
                event.getHook().sendMessage("""
                        ``도미니언`` - **10초간 범위 내 아군 모든 속성 저항 증가 100, 적 모든 속성 저항 감소 130**
                        ``엘의 영광`` - **10초간 아군 받는 피해 감소 5% * 3**
                        ``강렬한 파괴 스킬 (운명, 갈망)`` - **10초간 마법 방어력 감소 20%**""").queue();
            }
        }
    }
}
