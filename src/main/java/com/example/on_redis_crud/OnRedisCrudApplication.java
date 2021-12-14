package com.example.on_redis_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;

@SpringBootApplication
@EnableCaching
public class OnRedisCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnRedisCrudApplication.class, args);
    }
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
    @Bean
    HashOperations hashOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    SetOperations setOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    ListOperations listOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    ValueOperations valueOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    ZSetOperations zSetOperations(RedisTemplate redisTemplate) {
        return redisTemplate.opsForZSet();
    }


}
