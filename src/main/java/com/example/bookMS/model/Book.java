// src/main/java/com/example/backend/model/Book.java
package com.example.bookMS.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // PK (SequenceID / bookId)

    @Column(nullable = false, length = 255)
    private String title;           // 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;         // 내용(본문)

    @Column(columnDefinition = "TEXT")
    private String coverImageUrl;   // 표지 이미지 URL (ppt의 image)

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 생성일시

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 수정일시
}
