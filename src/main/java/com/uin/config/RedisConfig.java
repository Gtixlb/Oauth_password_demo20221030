package com.uin.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author wanglufei
 * @description: 使用redis存储我们的token
 * Redis配置类
 * @date 2022/4/11/11:17 PM
 */

@Configuration
public class RedisConfig {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * TokenStore会自动连接redis，将token存储到redis中
     *
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author wanglufei
     * @date 2022/4/11 11:20 PM
     */
    // @Bean
    // public TokenStore redisTokenStore() {
    //
    //     return new RedisTokenStore(redisConnectionFactory);
    // }
@Bean
    public TokenStore tokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        // tokenStore.setSerializationStrategy(new FastjsonRedisTokenStoreSerializationStrategy());
        return tokenStore;
    }

    /**
     * 配置RedisTemplate参数
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = serializer();
        RedisTemplate<String, Object>  redisTemplate                  = new RedisTemplate<>();
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(StringRedisSerializer.UTF_8);
        // value序列化方式采用fastjson
        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(StringRedisSerializer.UTF_8);
        //hash的value序列化方式采用
        redisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 此方法不能用@Ben注解，避免替换Spring容器中的同类型对象
     */
    public GenericFastJsonRedisSerializer serializer() {
        return new GenericFastJsonRedisSerializer();
    }
}
