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
    EmbedBuilder elsword_rune_master = new EmbedBuilder().setTitle("**룬 마스터 (룬마)**")
            .setAuthor("엘소드 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069172805410754620/img_pop_c1.png?width=497&height=473")
            .setColor(Color.red)
            .setDescription("""
                        ``피닉스 탤런`` - **9.75초간 이동속도 10%, 매 초 MP 1.5 회복**
                        ``룬의 영역`` - **10초간 영역 내 아군의 마법 공격력 증가 5%, 10초간 [룬의 각인] 디버프 대상이 받는 마법 피해 증가 5%**
                        ``[체인지]루나 블레이드`` - **7초간 모든 속성 저항 감소 50**
                        ``인챈트 브레이크`` - **5초간 모든 속성 저항 감소 130**
                        ``마력의 사슬`` - **10초간 마법 방어력 감소 12%**
                        ``윈드 블레이드, 라이징 슬래시, 스톰 블레이드 (마력의 흐름)`` - **10초간 모든 속성 저항 감소 30 * 3**""");
    EmbedBuilder elsword_immortal = new EmbedBuilder().setTitle("**임모탈**")
            .setAuthor("엘소드 3라인")
            .setThumbnail("https://cdn.discordapp.com/attachments/1010960966260891658/1069172941209735208/ebaaa8ed8388eba788ed81b4ec9dbceb9fac2e706e67.png")
            .setColor(Color.red)
            .setDescription("""
                        ``콘웰을 사용하는 스킬 (전투의 달인)`` - **5초간 받는 피해 증가 10%**
                        ``[체인지] 인피니티 체이서`` - **약 4초간 범위 내 아군의 공격력 증가 10%, 이동속도 증가 30%**
                        """);
    EmbedBuilder elsword_genesis = new EmbedBuilder().setTitle("**제네시스 (제네)**")
            .setAuthor("엘소드 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069173096185069569/img_char2.png?width=386&height=473")
            .setColor(Color.red)
            .setDescription("""
                        ``도미니언`` - **10초간 범위 내 아군 모든 속성 저항 증가 100, 적 모든 속성 저항 감소 130**
                        ``엘의 영광`` - **10초간 아군 받는 피해 감소 5% * 3**
                        ``강렬한 파괴 스킬 (운명, 갈망)`` - **10초간 마법 방어력 감소 20%**""");
    EmbedBuilder aisha_aether_sage = new EmbedBuilder().setTitle("에테르 세이지 (에세)")
            .setAuthor("아이샤 1라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069179698288001065/EC9584EC9DB4EC83A41-3ED9484EBA19CEBAAA8EC8598EC9DBCEB9FACEC8AA4ED8AB8.png?width=411&height=473")
            .setColor(new Color(178, 102, 255))
            .setDescription("""
                    `지혜의 문장` - **39초간 마법 공격력 증가 2% (40만 전투력 당 +2% (최대 25%))**
                    `블리자드 샤워` - **빙결 3.9초(각성 시 6.5초)**""");
    EmbedBuilder aisha_oz = new EmbedBuilder().setTitle("오즈 소서러 (오즈)")
            .setAuthor("아이샤 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069179729678176316/EC9584EC9DB4EC83A4.png?width=497&height=473")
            .setColor(new Color(178, 102, 255))
            .setDescription("""
                    가속의 문장 - 39초간 물리/마법 공격력 증가 10%, 동작속도, 이동속도, 점프속도 증가 10%
                    쁘띠 앙고르, [체인지] 쁘띠 앙고르 - 10초간 마법 방어력 감소 30%
                    팬텀 브리딩 - 5초간 아군 모든 속성 발동 확률 증가 6.5%, 모든 속성 저항 증가 162.5, 모든 속성 저항 감소 260
                    다크 웹 - MP 10%씩 3회 회복
                    에이징, [체인지] 에이징 - 20초간 공격력 감소 52%, 동작속도 및 이동속도 감소 52%, 추가 데미지 감소 100%""");
    EmbedBuilder aisha_metamorphy = new EmbedBuilder().setTitle("메타모르피 (메타)")
            .setAuthor("아이샤 3라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069179769087868958/2_EC9584EC9DB4EC83A4_EBA994ED8380EBAAA8EBA5B4ED94BC_1.png?width=425&height=473")
            .setColor(new Color(178, 102, 255))
            .setDescription("""
                    힘의 문장 - 39초간 물리 공격력 증가 2% (40만 전투력 당 +2% (최대 25%))
                    공간 왜곡 - 4초간 매 초 쿨타임 감소 0.7초
                    임팩트 존, [체인지] 임팩트 존 - 6초간 물리 방어력 감소 30%
                    해방된 의지 : 디멘션 위치 - 5초간 물리 방어력 감소 5% * 10""");
    EmbedBuilder aisha_Lord_Azoth = new EmbedBuilder().setTitle("로드 아조트 (로아)")
            .setAuthor("아이샤 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069179869054906378/FEEIYWcaIAAb-IP.png?width=486&height=473")
            .setColor(new Color(178, 102, 255))
            .setDescription("""
                    전충의 문장 - 39초간 최대 HP 15%, 최대 MP 50 증가
                    미스틱 플라스크 - 백색 - 물약 획득 시 39초간 캐릭터 크기 증가, 크리티컬 데미지 증가 10%
                    미스틱 플라스크 - 청색 - 물약 획득 시 39초간 캐릭터 크기 감소, 초당 MP 30씩 자연 회복
                    미스틱 플라스크 - 황색 - 물약 획득 시 26초간 슈퍼아머
                    미스틱 플라스크 - 자색 - 물약 획득 시 2.6초간 혼란 상태이상
                    리파인드 - 32.5초간 적 물리/마법 방어력 10% 감소, 디버프 해제 및 디버프 해제 시[1] 32.5초간 모든 스킬 데미지 증가 10%
                    엔벨롭스 - 10초간 영역 내 아군 받는 피해 감소 20%
                    아르케-마테르 - 15초간[A] 물리/마법 방어력 무시 증가 5%
                    아르케-메루스 - 15초간[A] 모든 속도 증가 5%
                    조화 - 15초간 아군이 독 디버프를 가진 적에게 주는 피해 증가 10%
                    현자의 돌 - 15초간 물리/마법 공격력 증가 10%, 8초10초간[4] 퀵 슬롯 아이템의 재사용 대기 시간 15초로 변경
                    아페이론 - 시전자 HP가 0이 될 시 주변 아군의 HP/MP를 5초동안 초당 20%씩 회복""");


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
        StringSelectMenu elsword_line= StringSelectMenu.create("menu:elsword")
                .setPlaceholder("라인 선택")
                .setRequiredRange(1, 1)
                .addOption("나이트 엠퍼러", "knight_emperor")
                .addOption("룬 마스터", "rune_master")
                .addOption("임모탈", "immortal")
                .addOption("제네시스", "genesis")
                .build();
        StringSelectMenu aisha_line= StringSelectMenu.create("menu:aisha")
                .setPlaceholder("라인 선택")
                .setRequiredRange(1, 1)
                .addOption("에테르 세이지", "aether_sage")
                .addOption("오즈 소서러", "oz")
                .addOption("메타모르피", "metamorphy")
                .addOption("로드 아조트", "lord_azoth")
                .build();


        if(event.getComponentId().equals("menu:character")) {
            if(event.getValues().get(0).equals("Elsword")){
                event.deferReply().setEphemeral(true).addActionRow(elsword_line).queue();
            }
            if(event.getValues().get(0).equals("Aisha")){
                event.deferReply().setEphemeral(true).addActionRow(aisha_line).queue();
            }
        }
        if(event.getComponentId().equals("menu:elsword")) { //엘소드 시너지
            event.deferReply().setEphemeral(true).queue();
            if(event.getValues().get(0).equals("knight_emperor")) {
                event.getHook().sendMessageEmbeds(elsword_knight_emperor.build()).queue();
            }
            if(event.getValues().get(0).equals("rune_master")) {
                event.getHook().sendMessageEmbeds(elsword_rune_master.build()).queue();
            }
            if(event.getValues().get(0).equals("immortal")) {
                event.getHook().sendMessageEmbeds(elsword_immortal.build()).queue();
            }
            if(event.getValues().get(0).equals("genesis")) {
                event.getHook().sendMessageEmbeds(elsword_genesis.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:aisha")) { //엘소드 시너지
            event.deferReply().setEphemeral(true).queue();
            if(event.getValues().get(0).equals("aether_sage")) {
                event.getHook().sendMessageEmbeds(aisha_aether_sage.build()).queue();
            }
            if(event.getValues().get(0).equals("oz")) {
                event.getHook().sendMessageEmbeds(aisha_oz.build()).queue();
            }
            if(event.getValues().get(0).equals("metamorphy")) {
                event.getHook().sendMessageEmbeds(aisha_metamorphy.build()).queue();
            }
            if(event.getValues().get(0).equals("lord_azoth")) {
                event.getHook().sendMessageEmbeds(aisha_Lord_Azoth.build()).queue();
            }
        }
    }
}
