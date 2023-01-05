package org.thalia.service.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.thalia.clients.feign")
@PropertySources({@PropertySource("classpath:feign-${spring.profiles.active}.properties")})

public class ArticleServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApp.class, args);
    }
}
