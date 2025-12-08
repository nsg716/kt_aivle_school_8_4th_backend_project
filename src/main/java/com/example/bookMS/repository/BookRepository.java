// src/main/java/com/example/bookMS/repository/BookRepository.java
package com.example.bookMS.repository;

import com.example.bookMS.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 🔹 특정 userId가 작성한 책만 조회
    List<Book> findByUserId(Long userId);
}
