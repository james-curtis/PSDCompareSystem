package com.example.compare;

import com.example.compare.mapper.AttachmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompareApplicationTests {

    @Autowired
    AttachmentMapper mapper;
    @Test
    void contextLoads() {
        mapper.selectList(null);
    }

}
