// src/main/java/com/example/bookMS/model/BookDTO.java
package com.example.bookMS.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BookDTO {

    private Long id;
    private String title;
    private String content;
    private String coverImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 🔹 어떤 유저가 등록한 책인지 구분하기 위한 필드
    private Long userId;
}
