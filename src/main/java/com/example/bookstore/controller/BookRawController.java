package com.example.bookstore.controller;

import com.example.bookstore.entity.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class BookRawController {

	private final List<Book> bookDB = new ArrayList<>();
	
	/*@Autowired
	private BookRecordService bookService;*/
	
	@PostConstruct
	private void initDB() {
		bookDB.add(new Book(1, "9728324632120", "Alice's Adventures in Wonderland", "Lewis Carroll", "Apex Publisher", 2001, 120));
		bookDB.add(new Book(2, "9238651732910", "1984", "George Orwell", "Carmen Publisher", 1995, 210));
		bookDB.add(new Book(3, "9238651732910", "The Odyssey", "Homer", "Bill Publisher", 2004, 185));
	}
	
	@GetMapping("/booksRaw")
	public ResponseEntity<List<Book>> getBooks(){
		return ResponseEntity.ok().body(bookDB);
	}
	
	@GetMapping("/bookRaw/{id}")
	public ResponseEntity<Book> getOneBook(@PathVariable("id") int id){
		Optional<Book> bookOp = bookDB.stream()
				.filter(p -> p.getId() == id)
				.findFirst();
		
		if(!bookOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Book book = bookOp.get();
		return ResponseEntity.ok().body(book);
	}

}