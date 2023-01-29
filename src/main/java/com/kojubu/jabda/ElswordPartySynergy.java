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
                    `가속의 문장` - **39초간 물리/마법 공격력 증가 10%, 동작속도, 이동속도, 점프속도 증가 10%**
                    `쁘띠 앙고르`, **[체인지] 쁘띠 앙고르 - 10초간 마법 방어력 감소 30%**
                    `팬텀 브리딩` - **5초간 아군 모든 속성 발동 확률 증가 6.5%, 모든 속성 저항 증가 162.5, 모든 속성 저항 감소 260**
                    `다크 웹` - **MP 10%씩 3회 회복**
                    `에이징`, **[체인지] 에이징 - 20초간 공격력 감소 52%, 동작속도 및 이동속도 감소 52%, 추가 데미지 감소 100%**""");
    EmbedBuilder aisha_metamorphy = new EmbedBuilder().setTitle("메타모르피 (메타)")
            .setAuthor("아이샤 3라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069179769087868958/2_EC9584EC9DB4EC83A4_EBA994ED8380EBAAA8EBA5B4ED94BC_1.png?width=425&height=473")
            .setColor(new Color(178, 102, 255))
            .setDescription("""
                    `힘의 문장` - **39초간 물리 공격력 증가 2% (40만 전투력 당 +2% (최대 25%))**
                    `공간 왜곡` - **4초간 매 초 쿨타임 감소 0.7초**
                    `임팩트 존`, **[체인지] 임팩트 존 - 6초간 물리 방어력 감소 30%**
                    `해방된 의지` : **디멘션 위치 - 5초간 물리 방어력 감소 5% * 10**""");
    EmbedBuilder aisha_Lord_Azoth = new EmbedBuilder().setTitle("로드 아조트 (로아)")
            .setAuthor("아이샤 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069179869054906378/FEEIYWcaIAAb-IP.png?width=486&height=473")
            .setColor(new Color(178, 102, 255))
            .setDescription("""
                    `전충의 문장` - **39초간 최대 HP 15%, 최대 MP 50 증가**
                    `미스틱 플라스크` - **백색 - 물약 획득 시 39초간 캐릭터 크기 증가, 크리티컬 데미지 증가 10%**
                    `미스틱 플라스크` - **청색 - 물약 획득 시 39초간 캐릭터 크기 감소, 초당 MP 30씩 자연 회복**
                    `미스틱 플라스크` - **황색 - 물약 획득 시 26초간 슈퍼아머**
                    `미스틱 플라스크` - **자색 - 물약 획득 시 2.6초간 혼란 상태이상**
                    `리파인드` - **32.5초간 적 물리/마법 방어력 10% 감소, 디버프 해제 및 디버프 해제 시[1] 32.5초간 모든 스킬 데미지 증가 10%**
                    `엔벨롭스` - **10초간 영역 내 아군 받는 피해 감소 20%**
                    `아르케-마테르` - **15초간[A] 물리/마법 방어력 무시 증가 5%**
                    `아르케-메루스` - **15초간[A] 모든 속도 증가 5%**
                    `조화` - **15초간 아군이 독 디버프를 가진 적에게 주는 피해 증가 10%**
                    `현자의 돌` - **15초간 물리/마법 공격력 증가 10%, 8초10초간[4] 퀵 슬롯 아이템의 재사용 대기 시간 15초로 변경**
                    `아페이론` - **시전자 HP가 0이 될 시 주변 아군의 HP/MP를 5초동안 초당 20%씩 회복**""");

    EmbedBuilder rena_wind_sneaker = new EmbedBuilder().setTitle("아네모스 (아네)")
            .setAuthor("레나 1라인")
            .setColor(Color.green)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069198609754632252/EBA088EB82981-3_ED9484EBA19CEBAAA8EC8598_EC9DBCEB9FACEC8AA4ED8AB8.png?width=432&height=473")
            .setDescription("""
                    `아이레린나` - 30초간 공격력 증가 10%, 모든속도 증가 15%, 초당 MP 7% 회복
                    `백 킥` - 10초간 공격력 감소 26%
                    """);
    EmbedBuilder rena_daybreaker = new EmbedBuilder().setTitle("데이브레이커 (데브)")
            .setAuthor("레나 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069198667736690728/EB8DB0EC9DB4EBB88CEBA088EC9DB4ECBBA4.png?width=497&height=473")
            .setColor(Color.green)
            .setDescription("""
                    `프리징 애로우, [체인지] 프리징 애로우` - 빙결 3.9초(각성 시 6.5초)[5]
                    `낙인의 사격`- 10초간 추가 피해 10%, 받는 크리티컬 피해 증가 15%, 마법 방어력 감소 20% (낙인의 흔적과 중복되지 않음)
                    `낙인의 흔적` - 10초간(타겟이 5 이상일 경우 20초간) 추가 피해 20%, 받는 크리티컬 피해 증가 15%, 마법 방어력 감소 25% (낙인의 사격과 중복되지 않음)
                    """);
    EmbedBuilder rena_twilight = new EmbedBuilder().setTitle("트와일라잇 (트와)")
            .setAuthor("레나 3라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069198768047669288/3_EBA088EB8298_ED8AB8EC9980EC9DBCEB9DBCEC9E87.png?width=547&height=473")
            .setColor(Color.green)
            .setDescription("""
                    `이보크` - 6초간 받는 피해 감소 40%, 물리 방어력 감소 40%
                    `트래핑 애로우` - 펑거스, [체인지] 트래핑 애로우 - 펑거스 - 10초간 받는 피해 증가 20%
                    `레이지 펑거스` - 구속 3.9초
                    """);
    EmbedBuilder rena_prophetess = new EmbedBuilder().setTitle("프로피티스 (프피)")
            .setAuthor("레나 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069199031366062100/FXB5iltaAAAYD3H.png?width=412&height=473")
            .setColor(Color.green)
            .setDescription("""
                    `리슨` - **랜덤하게 아군 MP 50 회복, 또는 특수 자원[특수자원] 20% 회복, 또는 둘 다 적용**
                    `튜닝` - **약 5초간 아군의 디버프를 지속적으로 제거**
                    `엠파시스` - **5초간 아군 슈퍼아머**
                    `해방된 의지 : 테일 스피너` - **랜덤하게 중간보스 및 보스에게 입히는 데미지 증가 2% (최대 5중첩), 또는 중간보스 및 보스가 아닌 적에게 입히는 데미지 증가 2% (최대 5중첩) (발동 이후 영구 적용)**
                    `리터러시 - [강인한 용기]` - **5초간 스킬 재사용 시간 가속화 1.5배**
                    `리터러시 - [강렬한 의지]` - **20초간 마법 공격력 증가 15%**
                    `리터러시 - [초월한 마음]` - **20초간 물리, 마법 방어력 증가 15%, 디버프 1종 제거**
                    `리터러시 - [강인한 울림]` - **30초간 크리티컬 확률 증가 20%**
                    `리터러시 - [강렬한 울림]` - **30초간 보스에게 입는 피해 감소 15%**
                    `리터러시 - [초월한 울림]` - **30초간 최대 HP의 10%만큼 보호막 생성 및 모든 피해량 증가 10%**
                    `변덕스러운 축복` - 아래의 효과 중 랜덤하게 2종 영구 적용 (새로운 축복으로 갱신 가능)
                    ```3단계 이상 마스터 스킬 사용 시 물리 공격력 1% 증가 (최대 10중첩)
                    3단계 이상 마스터 스킬 사용 시 마법 공격력 1% 증가 (최대 10중첩)
                    아군 부활 시 살아있는 아군의 스페셜 액티브 스킬 1개의 재사용 대기 시간 초기화
                    중간보스, 보스 몬스터를 아군이 처치 시 하이퍼 액티브 데미지 2% 증가 (최대 5중첩)
                    스페셜 액티브 사용 시 최대 MP의 10% MP 회복
                    액티브 스킬 사용 시 동작속도 1% 증가 (최대 10중첩)
                    마스터 스킬 사용 시 물리, 마법 방어력 1% 증가 (최대 10중첩)
                    퀵슬롯 아이템 사용 시 회복 아이템 효과 1% 증가 (최대 10중첩)
                    각성 상태일 경우 최대 MP 40 증가```
                    """);


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("엘소드_시너지")) return;

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
                .setPlaceholder("엘소드 라인 선택")
                .setRequiredRange(1, 1)
                .addOption("나이트 엠퍼러", "knight_emperor")
                .addOption("룬 마스터", "rune_master")
                .addOption("임모탈", "immortal")
                .addOption("제네시스", "genesis")
                .build();
        StringSelectMenu aisha_line= StringSelectMenu.create("menu:aisha")
                .setPlaceholder("아이샤 라인 선택")
                .setRequiredRange(1, 1)
                .addOption("에테르 세이지", "aether_sage")
                .addOption("오즈 소서러", "oz")
                .addOption("메타모르피", "metamorphy")
                .addOption("로드 아조트", "lord_azoth")
                .build();
        StringSelectMenu rena_line = StringSelectMenu.create("menu:rena")
                .setPlaceholder("레나 라인 선택")
                .setRequiredRange(1, 1)
                .addOption("아네모스", "wind_sneaker")
                .addOption("데이브레이커", "daybreaker")
                .addOption("트와일라잇", "twilight")
                .addOption("프로피티스", "prophetess")
                .build();


        if(event.getComponentId().equals("menu:character")) {
            if(event.getValues().get(0).equals("Elsword")){
                event.deferReply().setEphemeral(true).addActionRow(elsword_line).queue();
            }
            if(event.getValues().get(0).equals("Aisha")){
                event.deferReply().setEphemeral(true).addActionRow(aisha_line).queue();
            }
            if(event.getValues().get(0).equals("Rena")) {
                event.deferReply().setEphemeral(true).addActionRow(rena_line).queue();
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
        if(event.getComponentId().equals("menu:aisha")) { //아이샤 시너지
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
        if(event.getComponentId().equals("menu:rena")) {
            event.deferReply().setEphemeral(true).queue();
            if(event.getValues().get(0).equals("wind_sneaker")) {
                event.getHook().sendMessageEmbeds(rena_wind_sneaker.build()).queue();
            }
            if(event.getValues().get(0).equals("daybreaker")) {
                event.getHook().sendMessageEmbeds(rena_daybreaker.build()).queue();
            }
            if(event.getValues().get(0).equals("twilight")) {
                event.getHook().sendMessageEmbeds(rena_twilight.build()).queue();
            }
            if(event.getValues().get(0).equals("prophetess")) {
                event.getHook().sendMessageEmbeds(rena_prophetess.build()).queue();
            }
        }
    }
}
