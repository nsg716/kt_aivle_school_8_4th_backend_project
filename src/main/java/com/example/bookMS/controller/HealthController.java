package com.example.bookMS.controller; // 너 프로젝트 패키지에 맞춰 수정

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}