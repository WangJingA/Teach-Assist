package com.boot.teach.common.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * redis键和值存储的json化
 * 将redis存储键为string，值为json
 */
@Configuration
public class RedisJsonConfig {
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
       RedisTemplate<String,Object> redisTemplate = new RedisTemplate();
       redisTemplate.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
       //普通键值的序列化
       redisTemplate.setKeySerializer(RedisSerializer.string());
       redisTemplate.setValueSerializer(jsonRedisSerializer);

       //hash键值的序列化
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        return  redisTemplate;
    }
}
