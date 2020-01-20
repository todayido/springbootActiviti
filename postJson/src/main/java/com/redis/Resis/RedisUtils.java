package com.redis.Resis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class RedisUtils {
    public Jedis getRedis(){
        Jedis jedis = new Jedis("192.168.65.128");
        System.out.println("====================== redis 连接成功 ====================== ");
        return jedis;
    }
}
