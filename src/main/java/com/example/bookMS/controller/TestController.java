package com.example.bookMS.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${app.version}")
    private String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
