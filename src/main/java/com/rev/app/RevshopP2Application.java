package com.rev.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.rev.app.repository")
@EntityScan(basePackages = "com.rev.app.entity")
@ComponentScan(basePackages = "com.rev.app")
public class RevshopP2Application {

    public static void main(String[] args) {
        SpringApplication.run(RevshopP2Application.class, args);
    }

}

