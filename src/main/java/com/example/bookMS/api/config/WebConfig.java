package com.example.bookMS.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 프론트엔드(5173)와 백엔드(8080) 간 CORS 오류 방지를 위한 설정 클래스
 * /api/** 로 시작하는 모든 API 경로에 대해 특정 Origin 허용
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // 프론트엔드에서 호출하는 모든 API 경로(/api/**)에 대해 CORS 허용
        registry.addMapping("/api/**")

                // Vite 개발 서버의 기본 주소(React, Vue 등)
                .allowedOrigins("http://localhost:5173")

                // 사용할 HTTP 메서드 명시
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")

                // 요청 헤더 제한 없음
                .allowedHeaders("*")

                // 쿠키·토큰 같은 Credential 허용
                .allowCredentials(true)

                // 브라우저 Preflight 캐싱 시간(1시간)
                .maxAge(3600);
    }
}