package com.example.compare;

import com.example.compare.mapper.AttachmentMapper;
import com.example.compare.service.OrderLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompareApplicationTests {

    @Autowired
    AttachmentMapper mapper;

    @Autowired
    OrderLogService service;
    @Test
    void contextLoads() {
//        System.out.println(service.insertOrderLog());
        System.out.println(service.getOrderLog("31cac010-2860-44b8-aba1-3d91389b81ca"));
    }

}
