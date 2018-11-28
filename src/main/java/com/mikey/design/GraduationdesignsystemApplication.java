package com.mikey.design;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages={"com.mikey.design.Mapper"})
@SpringBootApplication
public class GraduationdesignsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationdesignsystemApplication.class, args);
    }
}
