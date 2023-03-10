package com.kojubu.bot;

import javax.security.auth.login.LoginException;

import com.kojubu.event.GenericListenerAdapterEvents;
import com.kojubu.jabda.*;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.Arrays;

public class Kojububot {
    private final ShardManager shardManager;
    public static final GatewayIntent[] INTENTS = { GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.DIRECT_MESSAGE_REACTIONS, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.GUILD_BANS,
            GatewayIntent.GUILD_EMOJIS_AND_STICKERS, GatewayIntent.GUILD_INVITES, GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS, GatewayIntent.GUILD_MESSAGE_TYPING,
            GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_WEBHOOKS,
            GatewayIntent.MESSAGE_CONTENT};

    public Kojububot() throws LoginException {
        String token = "token";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.listening("안뇽~"));
        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListeners(new GenericListenerAdapterEvents(),
                  new KojubuMusicCommands(), new slashcommandinfo(), new helpInfo(), new GuildChannelLogs(), new ElswordPartySynergy(),
                new ButtonMenu(), new musicChannelFunction(), new commandUtils());
        builder.enableIntents(Arrays.asList(INTENTS));
        builder.enableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.ROLE_TAGS, CacheFlag.STICKER, CacheFlag.ACTIVITY);
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
    
    public static void main(String[] args) {
        try {
            Kojububot kojubu = new Kojububot();
        } catch (LoginException e) {
            System.out.println("check the token!");
        }
        finally {
            System.out.println("everything is fine :)");
        }
    }
}
