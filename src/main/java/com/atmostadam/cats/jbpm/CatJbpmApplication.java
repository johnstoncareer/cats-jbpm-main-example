package com.atmostadam.cats.jbpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.atmostadam.cats.jbpm")
@EntityScan("com.atmostadam.cats")
public class CatJbpmApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatJbpmApplication.class, args);
    }
}
