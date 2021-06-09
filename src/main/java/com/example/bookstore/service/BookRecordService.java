package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.parameter.BookQueryParameter;
import com.example.bookstore.repository.BookRecordDAO;

@Service
public class BookRecordService {
	
	@Autowired
	private BookRecordDAO bookRecordDAO;
	
	public Book getBookRecord(int id) {
		return bookRecordDAO.find(id).orElseThrow(() -> new NotFoundException("Cannot find the book"));
	}
	
	public List<Book> getBookRecords(BookQueryParameter param) {
		return bookRecordDAO.find(param);
	}
	
	public Book postBookRecord(Book requestBook) {
		return bookRecordDAO.insert(requestBook);
	}
	
	public Book putBookRecord(int id, Book requestBook) {
		Book book = getBookRecord(id);
		return bookRecordDAO.replace(book.getId(), requestBook);
	}
	
	public void deleteBookRecord(int id) {
		Book book = getBookRecord(id);
		bookRecordDAO.delete(book.getId());
	}
}
