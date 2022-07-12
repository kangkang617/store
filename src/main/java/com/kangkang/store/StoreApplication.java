package com.kangkang.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.kangkang.store.dao")
public class StoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StoreApplication.class, args);

    }

}
