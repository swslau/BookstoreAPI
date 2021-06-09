package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.DuplicatedException;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.parameter.BookQueryParameter;
import com.example.bookstore.repository.BookRecordRepository;

@Service
public class BookRecordService {
	
	@Autowired
	private BookRecordRepository bookRecordRepo;
	
	public Book getBookRecord(int id) {
		return bookRecordRepo.findById(id).orElseThrow(() -> new NotFoundException("Cannot find the book"));
	}
	
	public List<Book> getBookRecords(BookQueryParameter param) {
		return bookRecordRepo.findAll();
	}
	
	public Book postBookRecord(Book requestBook) {
		if(bookRecordRepo.findByIsbn(requestBook.getIsbn()).isPresent()) {
			throw new DuplicatedException("The book id already exists");
		}
		return bookRecordRepo.saveAndFlush(requestBook);
	}
	
	public Book putBookRecord(int id, Book requestBook) {
		Book b = getBookRecord(id);
		b.setIsbn(requestBook.getIsbn());
		b.setName(requestBook.getName());
		b.setAuthor(requestBook.getAuthor());
		b.setPublisher(requestBook.getPublisher());
		b.setPublishYear(requestBook.getPublishYear());
		b.setPrice(requestBook.getPrice());
		
		return bookRecordRepo.saveAndFlush(b);
	}
	
	public void deleteBookRecord(int id) {
		Book book = getBookRecord(id);
		bookRecordRepo.delete(book);
	}
}
