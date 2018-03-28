package com.wenqi.demo.controller;

import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.jedis.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private JedisClient jedisClient;

    @Autowired
    private StringRedisTemplate strRedis;
    @GetMapping("/test")
    public ResultModel test(){
        jedisClient.set("test1","hello");
        String test1 = jedisClient.get("test1");
        return ResultModel.ok(test1);
    }
    @GetMapping("/test2")
    public ResultModel test2(){
        strRedis.opsForValue().set("test2","hello2");
        return ResultModel.ok(strRedis.opsForValue().get("test2"));
    }
}
