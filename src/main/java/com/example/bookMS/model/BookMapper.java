// src/main/java/com/example/bookMS/model/BookMapper.java
package com.example.bookMS.model;

public class BookMapper {

    // BookDTO -> Book Entity (생성용)
    public static Book toEntity(BookDTO dto) {
        return Book.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .coverImageUrl(dto.getCoverImageUrl())
                .userId(dto.getUserId())          // 🔹 userId 매핑
                .build();
    }

    // Book Entity -> BookDTO
    public static BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getBookId())
                .title(book.getTitle())
                .content(book.getContent())
                .coverImageUrl(book.getCoverImageUrl())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .userId(book.getUserId())         // 🔹 userId 매핑
                .build();
    }

    // BookDTO로 Entity 업데이트
    public static void updateEntity(Book book, BookDTO dto) {
        if (dto.getTitle() != null) {
            book.setTitle(dto.getTitle());
        }
        if (dto.getContent() != null) {
            book.setContent(dto.getContent());
        }
        if (dto.getCoverImageUrl() != null) {
            book.setCoverImageUrl(dto.getCoverImageUrl());
        }
        // 보통 userId는 바꾸지 않지만, 필요하면 아래처럼 처리 가능
        // if (dto.getUserId() != null) {
        //     book.setUserId(dto.getUserId());
        // }
    }
}
