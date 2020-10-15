package com.kenan.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author kenan
 */
@SpringBootApplication
public class KnSpringApplication  extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(KnSpringApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(KnSpringApplication.class);
    }
}
