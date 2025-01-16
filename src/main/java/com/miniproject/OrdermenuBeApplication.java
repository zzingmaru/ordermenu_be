package com.miniproject;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class OrdermenuBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdermenuBeApplication.class, args);
    }

    @PostConstruct
    public void init() {
        // timezone 설정
        log.info("================= Web Server Start...........");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 모든 경로에 대한 HTTP 요청을 처리
                        .allowedMethods("*") // 모든 http 메소드를 허용
                        .allowedOrigins("http://localhost:3000") // "http://localhost:5173"에서 오는 요청만 허용
                        .allowCredentials(true);
            }
        };
    }

}
