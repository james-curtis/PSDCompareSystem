package com.example.compare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.compare.mapper")
public class CompareApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompareApplication.class, args);
    }

}
