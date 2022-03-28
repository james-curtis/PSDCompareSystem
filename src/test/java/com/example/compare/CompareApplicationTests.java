package com.example.compare;

import com.example.compare.mapper.AttachmentMapper;
import com.example.compare.mapper.CompareLogMapper;
import com.example.compare.service.OrderLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class CompareApplicationTests {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    OrderLogService service;

    @Autowired
    CompareLogMapper mapper;
    @Test
    void contextLoads() {
        System.out.println(mapper.getOutTradeId(2));
    }

}
