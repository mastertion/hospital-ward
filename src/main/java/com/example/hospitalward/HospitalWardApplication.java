package com.example.hospitalward;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.hospitalward.mapper.*")

public class HospitalWardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalWardApplication.class, args);
    }

}

