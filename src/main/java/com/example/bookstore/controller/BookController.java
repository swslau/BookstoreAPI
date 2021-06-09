package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entity.Book;
import com.example.bookstore.parameter.BookQueryParameter;
import com.example.bookstore.service.BookRecordService;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	
	@Autowired
	private BookRecordService bookRecordService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks(@ModelAttribute BookQueryParameter param){
		return ResponseEntity.ok().body(bookRecordService.getBookRecords(param));
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getOneBook(@PathVariable("id") int id){
		return ResponseEntity.ok().body(bookRecordService.getBookRecord(id));
	}
	
	@PostMapping
	public ResponseEntity<Book> createNewBook(@RequestBody Book request) {
		return ResponseEntity.ok().body(bookRecordService.postBookRecord(request));
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateOneBook(@PathVariable("id") int id, @RequestBody Book request){
		return ResponseEntity.ok().body(bookRecordService.putBookRecord(id, request));
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Book> deleteOneBook(@PathVariable("id") int id){
		bookRecordService.deleteBookRecord(id);
		return ResponseEntity.noContent().build();
	}

}