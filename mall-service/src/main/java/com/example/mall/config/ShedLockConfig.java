package com.example.mall.config;

import net.javacrumbs.shedlock.core.LockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author fuwei
 */
@Configuration
public class ShedLockConfig {

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory connectionFactory) {
        return new RedisLockProvider(connectionFactory);
    }

}
