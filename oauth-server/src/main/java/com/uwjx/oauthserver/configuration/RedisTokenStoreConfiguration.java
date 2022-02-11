package com.uwjx.oauthserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author wanghuan
 * @link https://huan.uwjx.com
 * @date 2022/2/11 15:00
 */
@Configuration
public class RedisTokenStoreConfiguration {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    TokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }
}
