package com.kojubu.jabda;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

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
                    `리파인드` - **32.5초간 적 물리/마법 방어력 10% 감소, 디버프 해제 및 디버프 해제 시 32.5초간 모든 스킬 데미지 증가 10%**
                    `엔벨롭스` - **10초간 영역 내 아군 받는 피해 감소 20%**
                    `아르케-마테르` - **15초간 물리/마법 방어력 무시 증가 5%**
                    `아르케-메루스` - **15초간 모든 속도 증가 5%**
                    `조화` - **15초간 아군이 독 디버프를 가진 적에게 주는 피해 증가 10%**
                    `현자의 돌` - **15초간 물리/마법 공격력 증가 10%, 8초10초간 퀵 슬롯 아이템의 재사용 대기 시간 15초로 변경**
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
                    `프리징 애로우, [체인지] 프리징 애로우` - 빙결 3.9초(각성 시 6.5초)
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
                    `리슨` - **랜덤하게 아군 MP 50 회복, 또는 특수 자원 20% 회복, 또는 둘 다 적용**
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
    EmbedBuilder raven_furious_blade = new EmbedBuilder().setTitle("퓨리어스 블레이드 (퓨블)")
            .setAuthor("레이븐 1라인")
            .setColor(Color.BLACK)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069208613362618368/EBA088EC9DB4EBB8901-3_ED9484EBA19CEBAAA8EC8598EC9DBCEB9FACEC8AA4ED8AB8.png?width=396&height=473")
            .setDescription("""
                    `아머 크래시` - **7초간 물리 방어력 감소 39%**
                    """);
    EmbedBuilder raven_raze_hearts = new EmbedBuilder().setTitle("레이즈 하츠 (레하)")
            .setAuthor("레이븐 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069208638046077038/EBA088EC9DB4ECA780ED9598ECB8A0.png?width=438&height=473")
            .setColor(Color.BLACK)
            .setDescription("""
                    `웨폰 크래시` - **7초간 공격력 감소 45%**
                    `[체인지]뉴클리어` - **5초간 마법 방어력 감소 20%, 모든 속성 저항 감소 150, 크리티컬로 받는 피해 증가 14%**
                    """);
    EmbedBuilder raven_nova = new EmbedBuilder().setTitle("노바 임퍼레이터 (노바)")
            .setAuthor("레이븐 3라인")
            .setColor(Color.BLACK)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069208680442114118/EB85B8EBB094EC9E84ED8DBCEBA088EC9DB4ED84B0.png?width=579&height=473")
            .setDescription("""
                    `이프리트 플레임` - **6.5초간 모든 방어력 감소 15%, 모든 속성 저항 감소 250**
                    ``이그니션 크로우 - 네이팜`` - **8.3초간 불길 속 적 받는 피해 증가 15%**
                    `오버히트 스킬 (실전의 대가)` - **[고열 감지] 버프 5중첩 도달 시 아군 MP 100 회복, 10초간 매 초 마다 MP 20씩 회복**
                    `용병의 생존전략` - **15초간 공격력, 방어력 증가 12%**
                    """);
    EmbedBuilder raven_revenant = new EmbedBuilder().setTitle("레버넌트 (레버)")
            .setAuthor("레이븐 4라인")
            .setColor(Color.BLACK)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069208762612711474/EBA088EBB284EB848CED8AB8-892x1024.png?width=412&height=473")
            .setDescription("""
                    `인터딕션` - **15초간 모든 속성 저항 감소 120 / 150 / 180**
                    `스프라우트` - **15초간 물리 공격 받는 피해 증가 5% / 7.5% / 10%**
                    `소울 크래시` - **7초간 크리티컬로 받는 피해 15% 증가**
                    `카타콤` - **30초간 강인한 / 강렬한 / 초월한 스킬 데미지 증가 4~20%**
                    `데스 스크림, [체인지] 데스 스크림` - **10초간 보스에게 받는 피해 감소 5% / 10% / 15%**
                    `머시리스 리벤지` - **적의 디버프 시간 증가 10% / 15% / 20%**
                    `침식` - **30초간 모든 방어력 감소 2~20%**
                    `말살, 망자의 길` - **흔적 흡수 시 랜덤한 스킬 1개의 재사용 시간 7초 감소, 모든 속도 증가 10%, HP 회복 10%**
                    `해방된 의지 : 뮤턴트 리퍼` - **체력 50% 이하일 경우 받는 피해 증가 10%, 체력 10% 이하일 경우 받는 피해 증가 15%, 30초간 모든 방어력 감소 20%**
                    """);
    EmbedBuilder eve_ultimate = new EmbedBuilder().setTitle("코드: 얼티메이트 (얼티)")
            .setAuthor("이브 1라인")
            .setColor(Color.white)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069211426004140082/450px-Portrait_-_Code_Ultimate_28Infobox29.png")
            .setDescription("""
                    `아토믹 실드` - **11초간 받는 피해 감소 25%**
                    """);
    EmbedBuilder eve_esencia = new EmbedBuilder().setTitle("코드: 에센시아 (에센)")
            .setAuthor("이브 2라인")
            .setColor(Color.white)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069211501459689562/img_pop_c5.png?width=497&height=473")
            .setDescription("""
                    `리즌 프라이드` - **15초간 크리티컬&극대화 증가 10%**
                    `리즌 프라이드 - 오베론` - **30초간 데미지 감소 스텟 감소 20%**
                    `리즌 프라이드 - 오필리어` - **30초간 속성 저항 수치 10 * 3 감소**
                    `치트 코드 : 룰 브레이크 - 오베론` - **오베론 주위의 아군 스페셜 액티브 스킬 데미지 증가 20%**
                    `치트 코드 : 룰 브레이크 - 오필리어` - **오필리어 주위의 아군 물리/마법 방어력 증가 20%, 받는 피해 감소 20%**
                    `치트 코드 : 룰 브레이크 - 페르디난드` - **페르디난드 주위의 아군 하이퍼 액티브 스킬 데미지 증가 30%**
                    """);
    EmbedBuilder eve_sariel = new EmbedBuilder().setTitle("코드: 사리엘")
            .setAuthor("이브 3라인")
            .setColor(Color.white)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069211554714763314/5_EC9DB4EBB88C_ECBD94EB939CEFBC9AEC82ACEBA6ACEC9798.png?width=490&height=473")
            .setDescription("""
                    `시너지 없음`
                    """);
    EmbedBuilder eve_antithese = new EmbedBuilder().setTitle("코드: 안티테제 (안티)")
            .setAuthor("이브 4라인")
            .setColor(Color.white)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069211581700911114/img.png?width=475&height=473")
            .setDescription("""
                    `화이트 박스` - **범위 내 자신과 아군의 모든 디버프 제거**
                    `퓨리파이` - **짧은 순간 받는 피해 감소 50% / 70% / 99.9%**
                    `프라이데이` - **(사망 시) 15초간 모든 피해 증가 30%, 받는 피해 증가 20%**
                    `매스커레이드` - **아군에게 20초간 효과 없는 디버프 2종 부여**
                    `3각성 코어 릴리즈 (해방된 의지 : 코드 페일리스)` - **5초간 물리 방어력 감소 30%**
                    """);
    EmbedBuilder chung_1line=new EmbedBuilder().setTitle("코멧 크루세이더 (코크)")
            .setAuthor("청 1라인")
            .setColor(Color.CYAN)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069223778300727306/ECB2AD_1-3_ED9484EBA19CEBAAA8EC8598EC9DBCEB9FACEC8AA4ED8AB828EC9DBCEBB09829.png?width=550&height=473")
            .setDescription("""
                    `아이언 하울링` - **5초간 물리 방어력 감소 10%, 범위 내 아군 모든 디버프 제거**
                    `버스트 울프` - **주변 아군 2명의 디버프를 피격 대상에게 최대 4개 전이**
                    `[체인지]버스트 울프` - **받는 피해 증가 10% (판데모니움과 중복되지 않음)**
                    `판데모니움` - **받는 피해 증가 20% ([체인지]버스트 울프와 중복되지 않음)**
                    `원더 월, [체인지] 원더 월` - **11.5초간 받는 피해 감소 50%, 슈퍼아머**
                    `래피드 가디언` - **12초간 동작속도 증가 8%, 스킬 쿨타임 가속 1.4배, MP 회수량 2배**
                    `마운틴 블라스트` - **빙결 1단계 3초 / 2단계 4초 / 3단계 이상 5초**
                    `아이언 하울링, 판데모니움, 칼라드볼그 페인, 래피드 가디언 (가디언 포스)` - **20초간 물리/마법 공격력 감소 30%, 방어력 감소 15%**
                    """);
    EmbedBuilder chung_2line=new EmbedBuilder().setTitle("페이탈 팬텀 (페팬)")
            .setAuthor("청 2라인")
            .setColor(Color.CYAN)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069223834613465088/img_pop_c6.png?width=497&height=473")
            .setDescription("""
                    `시너지 없음`
                    """);

    EmbedBuilder chung_3line=new EmbedBuilder().setTitle("센츄리온 (센츄)")
            .setAuthor("청 3라인")
            .setColor(Color.CYAN)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069223885133852713/img_pop_c61.png?width=579&height=473")
            .setDescription("""
                    `페이탈 캐논, [체인지] 페이탈 캐논` - **7초간 마법 방어력 감소 40%**
                    `지휘관의 표식` - **20초간 추가 피해 13%(가드 무시)**
                    `캐논 스트라이크` - **지휘관의 표식 부여**
                    `헤비 필드, [체인지] 헤비 필드` - **10초간 받는 피해량 증가 10%**
                    `택티컬 필드` - **20초간 슈퍼아머, 피해 감소 10%, 초당 MP 회복 6**
                    `[체인지]택티컬 필드` - **10초간 매 초 MP회복 6, 받는 피해 감소 40%, 중간보스/보스에게 주는 피해 증가 40%, 슈퍼아머 10초**
                    """);

    EmbedBuilder chung_4line=new EmbedBuilder().setTitle("디우스 아에르 (디아)")
            .setAuthor("청 4라인")
            .setColor(Color.CYAN)
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069224172754051122/4.png?width=445&height=473")
            .setDescription("""
                    `브레이브 커버` - **아군 1명에게 8초간 슈퍼아머, 데미지를 시전자가 대신 받음**
                    `[체인지] 브레이브 커버` - **15초간 아군 받는 데미지 감소 15%**
                    `홀리 그레일` - **5초간 아군 HP/MP를 초당 1.2~18%씩 회복**
                    `페더 크레스트` - **15초간 이동속도, 점프 속도 증가 26%, 동작 속도 증가 19.5%**
                    `글로리 레거시` - **10초간 모든 속성 저항 감소 150**
                    `어톤먼트` - **빙결 5초
                    `필랜스로피` - **5초간 영역 내 아군 디버프 지속적으로 제거**
                    `오러클(초월적인 고지)` - **20초간 아군 물리 공격력 증가 10%, 최대 HP 증가 20%, 슈퍼아머 상태 부여**
                    `보누스 오페라` - **아군 HP/MP 회복 100%**
                    `디우스 아에르(3단계 이상)` - **15초간 아군의 특수 자원[특수자원] 소모량 제거**
                    `선구자의 문장 발동(선구자의 기도, 빛나는 정의)` - **아군 HP/MP 회복 10%**
                    `선구자의 긍지 발동(선구자의 긍지)` - **15초간 아군 모든 스킬 데미지 증가 20%**
                    """);
    EmbedBuilder Ara_1line = new EmbedBuilder().setTitle("비천")
            .setAuthor("아라 1라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069228521559425054/EC9584EB9DBC1-3_ED9484EBA19CEBAAA8EC8598EC9DBCEB9FACEC8AA4ED8AB828EC9DBCEBB09829.png?width=430&height=473")
            .setColor(Color.ORANGE)
            .setDescription("""
                    `[체인지]용아 3식 : 팔괘장` - **4초간 받는 피해 증가 20%**
                    `화련` - **20초간 모든 속성 저항 감소 250, 받는 피해 증가 20%**
                    `맹호격` - **30초간 보스/중간보스를 제외한 적에게 주는 피해, 물리 공격력, 동작속도 10% 증가**
                    `맹호 오의 : 맹호파천 (맹호의 힘)` - **30초간 크리티컬 증가 20%, 크리티컬 데미지 증가 15%**
                    `맹호 4식 - 노도` - **5초간 모든 방어력 감소 33%**
                    `제압 : 정` - **8초간 모든 방어력 감소 35%**
                    `커맨드 / 액티브 공격 (창술의 극의)` - **5초간 모든 방어력 감소 20%**
                    """);
    EmbedBuilder Ara_2line = new EmbedBuilder().setTitle("범황")
            .setAuthor("아라 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069228571014467715/EC9584EB9DBC_3ECB0A8ECA084ECA781_EBB294ED99A9_ED9484EBA19CEBAAA8EC8598.png?width=446&height=473")
            .setColor(Color.ORANGE)
            .setDescription("""
                    `나찰 오의 : 연옥 (기력 발산)` - **30초간 마법 방어력 감소 40%, 모든 속성 저항 감소 100**
                    `제압 : 기` - **8초간 모든 방어력 감소 35%**
                    `화간접무 (3단계 이상)` - **5초간 받는 피해 증가 5%**
                    """);

    EmbedBuilder Ara_3line = new EmbedBuilder().setTitle("대라")
            .setAuthor("아라 3라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069228606938689576/img_pop_c7.png?width=579&height=473")
            .setColor(Color.ORANGE)
            .setDescription("""
                    `귀신걸음` - **7초간 물리 방어력 감소 58.5%**
                    `여우령` - **5초간 물리 방어력 감소 10%**
                    `제압 : 귀` - **8초간 모든 방어력 감소 35%**
                    `여우불꽃` - **빙결 4초 혹은 단죄 4초**
                    `술법 : 강령` - **20초간 초월한 스킬 데미지 증가 15%**
                    `[체인지]술법 : 강령` - **20초간 강렬한 스킬 데미지 증가 15%**
                    `여우 고개, 귀살 오의 : 백귀야행 (진혼)` - **구슬 획득한 아군 1명 1초간 MP회복 10%, 스킬 쿨타임 가속 2배 (구슬은 10초 유지)**
                    `[체인지] 그림자 꽃망울` - **7초간 크리티컬로 피해를 받을 확률 증가 30%**
                    `귀살 2식 : 귀신묶기, 귀살 3식 : 그림자 매듭, 귀살 4식 : 어둠가르기, 그림자 꽃망울 (마력 개방)` - **8초간 받는 피해 증가 10%**
                    """);
    EmbedBuilder Ara_4line = new EmbedBuilder().setTitle("일천")
            .setAuthor("아라 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069228736802717746/snsEC9584EB9DBC4-3-ED9484EBA19CEBAAA8EC8598-EC9DBCEB9FACEC8AA4ED8AB8-892x1024.png?width=412&height=473")
            .setColor(Color.ORANGE)
            .setDescription("""
                    `천구성` - **30초간 마법 공격력 증가 15%**
                    `제압 : 도` - **8초간 모든 방어력 감소 35%**
                    `현천 4식 : 막` - **30초간 받는 피해 감소 20%**
                    `현천 오의 - 파` - **30초간 자신의 HP의 최대 30%만큼 아군의 최대 HP 증가**
                    `성화` - **5초간 아군 HP/MP를 초당 1.2~18%씩 회복**
                    `변환` - **5초간 슈퍼아머 상태**
                    `호곡성` - **10초간 모든 속성 저항 감소 200**
                    `한빙호기` - **빙결 5초**
                    `천구성, 현천 4식 : 막, 성화, 변환 (합일)` - **30초간 모든 스킬 데미지 0.2~20% 증가**
                    """);
    EmbedBuilder elesis_1line=new EmbedBuilder().setTitle("엠파이어 소드 (엠소)")
            .setAuthor("엘리시스 1라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069459130827423754/25EC259725A025EC2586258C.png?width=504&height=473")
            .setColor(Color.red)
            .setDescription("""
                    `파워 브레이크` - **8초간 모든 방어력 감소 24%, 모든 속성 저항 감소 60(기가 블래스트와 중복되지 않음)**
                    `기가 블래스트` - **8초간 모든 방어력 감소 30%, 모든 속성 저항 감소 100(파워 브레이크와 중복되지 않음)**
                    `도발` - **9초간 받는 피해 증가 20%, 피격 대상 공격력 증가 10%**
                    `[체인지]도발` - **6초간 받는 피해 증가 20%, 피격 대상 공격력 증가 10%**
                    `워 프렐류드` - **12초간 커맨드/액티브/스페셜 액티브 데미지 증가 20%, 디버프 면역 상태**
                    `[체인지]워 프렐류드` - **36초간 스페셜 액티브 데미지 증가 15%, 받는 피해 감소 15%**
                    `기사단장의 위엄` - **크리티컬, 극대화, 동작속도, 추가 데미지 1.5% * (파티원 수)(최대 4중첩)**
                    """);
    EmbedBuilder elesis_2line=new EmbedBuilder().setTitle("플레임 로드 (플로)")
            .setAuthor("엘리시스 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069459165774356510/25ED2594258C25EB25A1259C.png")
            .setColor(Color.red)
            .setDescription("""
                    `불꽃의 낙인` - 8810초간 마법 방어력 감소 10% * 5(마력의 사슬과 중복되지 않음)**          
                    """);
    EmbedBuilder elesis_3line=new EmbedBuilder().setTitle("블러디 퀸 (블퀸)")
            .setAuthor("엘리시스 3라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069459193775542365/25EB25B8259425ED258025B8.png?width=473&height=473")
            .setColor(Color.red)
            .setDescription("""
                    `인젝션 스티그마` - **7.98초간 공격력 감소 2% * 20**
                    `블러드 폴즈` - **5초간 모든 속성 저항 감소 300**
                    """);
    EmbedBuilder elesis_4line=new EmbedBuilder().setTitle("아드레스티아 (아드)")
            .setAuthor("엘리시스 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069459690821517382/common.png?width=532&height=473")
            .setColor(Color.red)
            .setDescription("""
                    `아웃버스트` - **15초간 받는 마법 피해 증가 10%**
                    `엘리미네이션` - **10초간 마법 방어력 감소 20%**
                    `언브로큰 빌리프` - **체력이 30% 이하가 되면 체력 100% 회복**
                    `업사이드 다운` - **파티원 디버프 1종 제거 및 그 외 디버프 지속시간 감소 20%**
                    `카타르시스` - **10초간 크리티컬로 입는 피해 증가 10%**
                    `[디비누수 마누스] 섬멸 스킬 3회 사용 (자각)` - **12초간 모든 공격 방어력 무시 5%**
                    `[디비누수 마누스] 질풍 스킬 3회 사용 (자각)` - **12초간 스페셜 액티브 재사용 시간 감소 10%**
                    `파티원이 디버프 총합 20회 적용 (잠재의식)` - **20초간 물리, 마법 방어력 증가 20%**
                    ``패스브레이커`` - **중간보스, 보스 몬스터의 체력이 일정수치 이하일 때 다음 효과 적용**
                    ```1단계 - 몬스터 체력 100% : 동작속도 증가 10%
                    2단계 - 몬스터 체력 50% : 동작속도 증가 10%, 마법 공격력 증가 10%
                    3단계 - 몬스터 체력 30% : 동작속도 증가 10%, 마법 공격력 증가 10%, 중간보스 및 보스 몬스터에게 입히는 데미지 증가 10%```
                                        
                    """);
    EmbedBuilder add_1line = new EmbedBuilder().setTitle("둠 브링어 (둠브)")
            .setAuthor("애드 1라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069464717220925450/EC95A0EB939C1-3_ED9484EBA19CEBAAA8EC8598EC9DBCEB9FACEC8AA4ED8AB8.png?width=460&height=473")
            .setColor(new Color(127, 0 ,255))
            .setDescription("""
                    `[체인지]EMP 쇼크` - **공간 유지 중 1회에 한하여 스페셜 액티브 스킬 재사용 시간 5초 감소**
                    """);
    EmbedBuilder add_2line = new EmbedBuilder().setTitle("도미네이터 (도미)")
            .setAuthor("애드 2라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069465083790495795/25EB258F258425EB25AF25B8.png?width=446&height=473")
            .setColor(new Color(127, 0 ,255))
            .setDescription("""
                    `인스톨 - 드론 액티베이터` - **14.5초간 모든 방어력 감소 21.5%**
                    `인스톨 - 제로 켈빈 제너레이터` - 10초간 받는 피해 증가 19.5%, 빙결 5초**
                    `포스 필드` - **20초간 물리 공격력 증가 13.8%, 받는 피해 감소 13.8%**
                    `[체인지]포스 필드` - **10초간 물리 공격력 증가 11.5%, 크리티컬, 극대화, 크리티컬 데미지 11.5%, 각성 충전 속도 증가 34.5%**
                    """);
    EmbedBuilder add_3line = new EmbedBuilder().setTitle("매드 패러독스 (매패)")
            .setAuthor("애드 3라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069465188417425408/25EB25A725A425ED258C25A825EA25B0258125EC258425B1.png?width=490&height=473")
            .setColor(new Color(127, 0 ,255))
            .setDescription("""
                    `시간의 문장` - **쿨타임 감소 15초, HP/MP 100% 회복, 26초 내 사망 시 부활**
                    `[체인지] 정신붕괴` - **5초간 마법 방어력 감소 56%**
                    """);
    EmbedBuilder add_4line = new EmbedBuilder().setTitle("오버마인드 (오마)")
            .setAuthor("애드 4라인")
            .setThumbnail("https://media.discordapp.net/attachments/1010960966260891658/1069465565112053830/sunny.png?width=544&height=473")
            .setColor(new Color(127, 0 ,255))
            .setDescription("""
                    `이그제미네이션` - **5초간 모든 속성 저항 감소 150**
                    `스팀팩` - **(아군에게)10초간 공격력 증가 10% 및 방어력 감소 20%, (적군에게)10초간 공격력 증가 10% 및 방어력 감소 20%**
                    `큐어` - **즉시 HP/MP 40~55%와 특수 자원, 이후 7초간 아군 HP/MP를 초당 0.8~12%씩 회복**
                    `PCA` - **10초간 받는 피해 감소 14~20%**
                    `디톡시케이션, [체인지] 디톡시케이션` - **12초간 액티브, 스페셜 액티브 스킬 데미지 증가 18%**
                    `이뮤니티` - **디버프 해제 이후 3~6초간 디버프 면역 상태**
                    `펄스 다이그노시스` - **10초간 공격력 감소 20%**
                    `에네스티시아` - **빙결 3~5초**
                    `매스 이그제미네이션` - **아군의 조건에 따라 단계에 맞는 효과를 50초간 부여**
                    ```1단계 - 크리티컬 50% 이하 : 크리티컬 20% 증가
                    2단계 - 극대화 50% 이하 : 극대화 20% 증가
                    3단계 - 물리/마법 방어 무시 5% 이하 : 물리/마법 방어 무시 10% 증가
                    4단계 - 1~3단계에 해당되지 않을 경우 : 물리/마법 공격력 10% 증가```
                    `트롤리 딜레마` - **아군 1명에게 50초간 스페셜 액티브 스킬 쿨타임 감소 1.5배, 스페셜 액티브 스킬 MP 소모량 감소 20% 효과 부여**
                    `오버트리트먼트(스팀팩, 큐어, PCA, 디톡시케이션, 매스 이그제미네이션, 트롤리 딜레마)` - **아군에게 10초간 지속되는 디버프 부여 (1중첩씩 감소, 이뮤니티 스킬로만 해제 가능)**
                    ```1단계 - 1~20 중첩 : 중첩당 타격시 MP 회복량 0.25% 감소 (최대 5%)
                    2단계 - 21~40 중첩: 타격시 MP 회복량 5% 감소, 중첩당 각성 충전 속도(DP 회복량) 0.25% 감소 (최대 5%)
                    3단계 - 41~60 중첩: 타격시 MP 회복량 5% 감소, 중첩당 각성 충전 속도(DP 회복량) 5% 감소, 중첩당 크리티컬 확률 0.25% 감소 (최대 5%)
                    4단계 - 61~80 중첩: 타격시 MP 회복량 5% 감소, 중첩당 각성 충전 속도(DP 회복량) 5% 감소, 중첩당 크리티컬 확률 5% 감소, 중첩당 극대화 확률 0.25% 감소 (최대 5%)
                    5단계 - 81~100 중첩: 타격시 MP 회복량 5% 감소, 중첩당 각성 충전 속도(DP 회복량) 5% 감소, 중첩당 크리티컬 확률 5% 감소, 중첩당 극대화 확률 5% 감소, 중첩당 물리/마법 공격력 2.5% 감소 (최대 50%)```
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
        Object get_value = event.getValues().get(0);
        InteractionHook get_hook = event.getHook();
        ReplyCallbackAction setEphemeral_true = event.deferReply().setEphemeral(true);
        StringSelectMenu elsword_line= StringSelectMenu.create("menu:elsword")
                .setPlaceholder("엘소드 전직 선택")
                .setRequiredRange(1, 1)
                .addOption("나이트 엠퍼러", "knight_emperor")
                .addOption("룬 마스터", "rune_master")
                .addOption("임모탈", "immortal")
                .addOption("제네시스", "genesis")
                .build();
        StringSelectMenu aisha_line= StringSelectMenu.create("menu:aisha")
                .setPlaceholder("아이샤 전직 선택")
                .setRequiredRange(1, 1)
                .addOption("에테르 세이지", "aether_sage")
                .addOption("오즈 소서러", "oz")
                .addOption("메타모르피", "metamorphy")
                .addOption("로드 아조트", "lord_azoth")
                .build();
        StringSelectMenu rena_line = StringSelectMenu.create("menu:rena")
                .setPlaceholder("레나 전직 선택")
                .setRequiredRange(1, 1)
                .addOption("아네모스", "wind_sneaker")
                .addOption("데이브레이커", "daybreaker")
                .addOption("트와일라잇", "twilight")
                .addOption("프로피티스", "prophetess")
                .build();
        StringSelectMenu raven_line = StringSelectMenu.create("menu:raven")
                .setPlaceholder("레이븐 전직 선택")
                .setRequiredRange(1, 1)
                .addOption("퓨리어스 블레이드", "furious_blade")
                .addOption("레이즈 하츠", "raze_hearts")
                .addOption("노바 임퍼레이터", "nova")
                .addOption("레버넌트", "revenant")
                .build();
        StringSelectMenu eve_line=StringSelectMenu.create("menu:eve")
                .setPlaceholder("이브 전직 선택")
                .setRequiredRange(1, 1)
                .addOption("코드: 얼티메이트", "ultimate")
                .addOption("코드: 에센시아", "esencia")
                .addOption("코드: 사리엘", "sariel")
                .addOption("코드: 안티테제", "antithese")
                .build();
        StringSelectMenu chung_line=StringSelectMenu.create("menu:chung")
                .setPlaceholder("청 전직 선택")
                .setRequiredRange(1, 1)
                .addOption("코멧 크루세이더", "chung_1line")
                .addOption("페이탈 팬텀", "chung_2line")
                .addOption("센츄리온", "chung_3line")
                .addOption("디우스 아에르", "chung_4line")
                .build();
        StringSelectMenu ara_line=StringSelectMenu.create("menu:ara")
                .setPlaceholder("아라 전직 선택")
                .setRequiredRange(1,1)
                .addOption("비천", "ara_1line")
                .addOption("범황", "ara_2line")
                .addOption("대라", "ara_3line")
                .addOption("일천", "ara_4line")
                .build();
        StringSelectMenu elesis_line=StringSelectMenu.create("menu:elesis")
                .setPlaceholder("엘리시스 전직 선택")
                .setRequiredRange(1,1)
                .addOption("엠파이어 소드", "elesis_1line")
                .addOption("플레임 로드", "elesis_2line")
                .addOption("블러디 퀸", "elesis_3line")
                .addOption("아드레스티아", "elesis_4line")
                .build();
        StringSelectMenu add_line=StringSelectMenu.create("menu:add")
                .setPlaceholder("애드 전직 선택")
                .setRequiredRange(1,1)
                .addOption("둠 브링어", "add_1line")
                .addOption("도미네이터", "add_2line")
                .addOption("매드 패러독스", "add_3line")
                .addOption("오버마인드", "add_4line")
                .build();
        if(event.getComponentId().equals("menu:character")) {
            if(get_value.equals("Elsword")){
                setEphemeral_true.addActionRow(elsword_line).queue();
            }
            if(get_value.equals("Aisha")){
                setEphemeral_true.addActionRow(aisha_line).queue();
            }
            if(get_value.equals("Rena")) {
                setEphemeral_true.addActionRow(rena_line).queue();
            }
            if(get_value.equals("Raven")) {
                setEphemeral_true.addActionRow(raven_line).queue();
            }
            if(get_value.equals("Eve")) {
                setEphemeral_true.addActionRow(eve_line).queue();
            }
            if(get_value.equals("Chung")) {
                setEphemeral_true.addActionRow(chung_line).queue();
            }
            if(get_value.equals("Ara")) {
                setEphemeral_true.addActionRow(ara_line).queue();
            }
            if(get_value.equals("Elesis")) {
                setEphemeral_true.addActionRow(elesis_line).queue();
            }
            if(get_value.equals("Add")) {
                setEphemeral_true.addActionRow(add_line).queue();
            }
        }
        if(event.getComponentId().equals("menu:elsword")) { //엘소드 시너지
            setEphemeral_true.queue();
            if(get_value.equals("knight_emperor")) {
                get_hook.sendMessageEmbeds(elsword_knight_emperor.build()).queue();
            }
            if(get_value.equals("rune_master")) {
                get_hook.sendMessageEmbeds(elsword_rune_master.build()).queue();
            }
            if(get_value.equals("immortal")) {
                get_hook.sendMessageEmbeds(elsword_immortal.build()).queue();
            }
            if(get_value.equals("genesis")) {
                get_hook.sendMessageEmbeds(elsword_genesis.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:aisha")) { //아이샤 시너지
            setEphemeral_true.queue();
            if(get_value.equals("aether_sage")) {
                get_hook.sendMessageEmbeds(aisha_aether_sage.build()).queue();
            }
            if(get_value.equals("oz")) {
                get_hook.sendMessageEmbeds(aisha_oz.build()).queue();
            }
            if(get_value.equals("metamorphy")) {
                get_hook.sendMessageEmbeds(aisha_metamorphy.build()).queue();
            }
            if(get_value.equals("lord_azoth")) {
                get_hook.sendMessageEmbeds(aisha_Lord_Azoth.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:rena")) { //레나 시너지
            setEphemeral_true.queue();
            if(get_value.equals("wind_sneaker")) {
                get_hook.sendMessageEmbeds(rena_wind_sneaker.build()).queue();
            }
            if(get_value.equals("daybreaker")) {
                get_hook.sendMessageEmbeds(rena_daybreaker.build()).queue();
            }
            if(get_value.equals("twilight")) {
                get_hook.sendMessageEmbeds(rena_twilight.build()).queue();
            }
            if(get_value.equals("prophetess")) {
                get_hook.sendMessageEmbeds(rena_prophetess.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:raven")) { //레이븐 시너지
            setEphemeral_true.queue();
            if(get_value.equals("furious_blade")) {
                get_hook.sendMessageEmbeds(raven_furious_blade.build()).queue();
            }
            if(get_value.equals("raze_hearts")) {
                get_hook.sendMessageEmbeds(raven_raze_hearts.build()).queue();
            }
            if(get_value.equals("nova")) {
                get_hook.sendMessageEmbeds(raven_nova.build()).queue();
            }
            if(get_value.equals("revenant")) {
                get_hook.sendMessageEmbeds(raven_revenant.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:eve")) {//이브 시너지
            setEphemeral_true.queue();
            if(get_value.equals("ultimate")) {
                get_hook.sendMessageEmbeds(eve_ultimate.build()).queue();
            }
            if(get_value.equals("esencia")) {
                get_hook.sendMessageEmbeds(eve_esencia.build()).queue();
            }
            if(get_value.equals("sariel")) {
                get_hook.sendMessageEmbeds(eve_sariel.build()).queue();
            }
            if(get_value.equals("antithese")) {
                get_hook.sendMessageEmbeds(eve_antithese.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:chung")) {//청 시너지
            setEphemeral_true.queue();
            if(get_value.equals("chung_1line")){
                get_hook.sendMessageEmbeds(chung_1line.build()).queue();
            }
            if(get_value.equals("chung_2line")) {
                get_hook.sendMessageEmbeds(chung_2line.build()).queue();
            }
            if(get_value.equals("chung_3line")) {
                get_hook.sendMessageEmbeds(chung_3line.build()).queue();
            }
            if(get_value.equals("chung_4line")) {
                get_hook.sendMessageEmbeds(chung_4line.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:ara")) {//아라 시너지
            setEphemeral_true.queue();
            if(get_value.equals("ara_1line")) {
                get_hook.sendMessageEmbeds(Ara_1line.build()).queue();
            }
            if(get_value.equals("ara_2line")) {
                get_hook.sendMessageEmbeds(Ara_2line.build()).queue();
            }
            if(get_value.equals("ara_3line")) {
                get_hook.sendMessageEmbeds(Ara_3line.build()).queue();
            }
            if(get_value.equals("ara_4line")) {
                get_hook.sendMessageEmbeds(Ara_4line.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:elesis")) {//엘리시스 시너지
            setEphemeral_true.queue();
            if(get_value.equals("elesis_1line")){
                get_hook.sendMessageEmbeds(elesis_1line.build()).queue();
            }
            if(get_value.equals("elesis_2line")) {
                get_hook.sendMessageEmbeds(elesis_2line.build()).queue();
            }
            if(get_value.equals("elesis_3line")) {
                get_hook.sendMessageEmbeds(elesis_3line.build()).queue();
            }
            if(get_value.equals("elesis_4line")) {
                get_hook.sendMessageEmbeds(elesis_4line.build()).queue();
            }
        }
        if(event.getComponentId().equals("menu:add")) {//애드 시너지
            setEphemeral_true.queue();
            if(get_value.equals("add_1line")) {
                get_hook.sendMessageEmbeds(add_1line.build()).queue();
            }
            if(get_value.equals("add_2line")) {
                get_hook.sendMessageEmbeds(add_2line.build()).queue();
            }
            if(get_value.equals("add_3line")) {
                get_hook.sendMessageEmbeds(add_3line.build()).queue();
            }
            if(get_value.equals("add_4line")) {
                get_hook.sendMessageEmbeds(add_4line.build()).queue();
            }
        }
    }
}
