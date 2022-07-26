package com.comento.comentoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@EnableJpaAuditing
public class ComentoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComentoProjectApplication.class, args);
    }

}
