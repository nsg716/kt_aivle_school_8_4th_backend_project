package com.example.bookMS.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                        "http://localhost:5173",
                        "https://kt-aivle-school-8-4th-frontend-project-btg6fwyyh.vercel.app",
                        "https://d37difhmoiykfd.cloudfront.net",
                        "http://ai0917-front-prod.s3-website-ap-southeast-1.amazonaws.com"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
        // 쿠키/세션 안 쓰면 allowCredentials는 빼는게 안전
        // .allowCredentials(true);
    }
}