package com.rickish;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.rickish.mapper"})
public class RickishApplication {

    public static void main(String[] args) {
        SpringApplication.run(RickishApplication.class, args);
    }

}
