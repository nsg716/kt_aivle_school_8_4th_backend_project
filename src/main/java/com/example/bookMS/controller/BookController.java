package com.example.bookMS.controller;

import com.example.bookMS.model.BookDTO;
import com.example.bookMS.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;




    // 도서 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long bookId) {
        BookDTO book = bookService.getBook(bookId);
        return ResponseEntity.ok(book);
    }

    // 기존 도서 수정
    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable Long bookId,
            @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(bookId, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // 기존 도서 삭제
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    // 기존 도서 표지 수정 (URL 직접 넣어서 수정하는 경우)
    @PatchMapping("/{bookId}/cover")
    public ResponseEntity<BookDTO> updateBookCover(
            @PathVariable Long bookId,
            @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBookCover(bookId, bookDTO.getCoverImageUrl());
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBookList(@RequestParam Long userId) {
        List<BookDTO> bookList = bookService.getBookListByUser(userId);
        return ResponseEntity.ok(bookList);
    }

    // 🔹 도서 등록 (body 안에 userId 함께 보냄)
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

}
