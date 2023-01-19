package com.kojubu;

import javax.security.auth.login.LoginException;

import com.kojubu.event.EventListener;
import com.kojubu.jabda.KojubuCommands;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class AppTest {
    private final ShardManager shardManager;
    public AppTest() throws LoginException {
        String token = "tooken";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.listening("Kendrick"));
        builder.setStatus(OnlineStatus.IDLE);
        builder.addEventListeners(new EventListener(), new KojubuCommands());
        builder.enableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.ROLE_TAGS, CacheFlag.STICKER);
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            AppTest kojubu = new AppTest();
        } catch (LoginException e) {
            System.out.println("check the token!");
        } finally {
            System.out.println("everything is fine :)");
        }
    }
}
