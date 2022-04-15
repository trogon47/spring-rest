package com.markdemo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.markdemo")
public class MySpringRestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MySpringRestApplication.class, args);
    }
}
