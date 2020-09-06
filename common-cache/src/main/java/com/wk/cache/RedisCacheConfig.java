package com.wk.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisCacheConfig {
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory();
//	}
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	@Bean
	RedisTemplate< String, Long > longRedisTemplate() {
		final RedisTemplate<String, Long> template =  new RedisTemplate<>();
		template.setConnectionFactory( redisTemplate.getConnectionFactory() );
		template.setKeySerializer( new StringRedisSerializer() );
		template.setHashValueSerializer( new GenericToStringSerializer<>( Long.class ) );
		template.setValueSerializer( new GenericToStringSerializer<>( Long.class ) );
		return template;
	}
}
