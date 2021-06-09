package com.example.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;

@Repository
public interface BookRecordRepository extends JpaRepository<Book, Integer> {
	Optional<Book> findByIsbn(String isbn);
}
