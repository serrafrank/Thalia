package org.thalia.service.comment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"org.thalia.blog.comment", "org.thalia.message.server"})
@EnableEurekaClient
@PropertySources({@PropertySource("classpath:feign-${spring.profiles.active}.properties"),})

public class CommentServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApp.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

