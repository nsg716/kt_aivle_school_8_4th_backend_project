package com.example.bookMS.repository;

import com.example.bookMS.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    //findAll
    //findById
    //save
    //deleteById

}
