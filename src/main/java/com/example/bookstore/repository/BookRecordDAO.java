package com.example.bookstore.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.DuplicatedException;
import com.example.bookstore.parameter.BookQueryParameter;

class BookQueryParam {
	
}

@Repository
public class BookRecordDAO {
	private final List<Book> bookDB = new ArrayList<>();
	
	@PostConstruct
	private void initDB() {
		bookDB.add(new Book(1, "9728324632120", "Alice's Adventures in Wonderland", "Lewis Carroll", "Apex Publisher", 2001, 120));
		bookDB.add(new Book(2, "9238651732910", "1984", "George Orwell", "Carmen Publisher", 1995, 210));
		bookDB.add(new Book(3, "9238651732910", "The Odyssey", "Homer", "Bill Publisher", 2004, 185));
	}
	
	public Optional<Book> find(int id) {
		return bookDB.stream()
				.filter(b -> b.getId() == id)
				.findFirst();
	}
	
	public List<Book> find(BookQueryParameter param) {
		String isbnFilter = param.getIsbn();
		String orderBy = param.getOrderBy();
		String sortRule = param.getSortRule();
		
		Comparator<Book> comparator = Objects.nonNull(orderBy) && Objects.nonNull(sortRule) // require two query parameters
				? configureSortComparator(orderBy, sortRule) // customized order
				: (b1, b2) -> 0; // original order
		
		Stream<Book> resultStream = bookDB.stream()
							.sorted(comparator);
							
		if(isbnFilter != null && !isbnFilter.equals("")) {
			resultStream = resultStream.filter(b -> b.getIsbn().equals(isbnFilter));
		}
		
		List<Book> resultList = resultStream.collect(Collectors.toList());
		
		return resultList;
	}
	
	private Comparator<Book> configureSortComparator(String orderBy, String sortRule) {
		Comparator<Book> comparator = (b1, b2) -> 0;
		
		if(orderBy.equalsIgnoreCase("price")) {
			comparator = Comparator.comparing(Book::getPrice);
		} else if(orderBy.equalsIgnoreCase("name")) {
			comparator = Comparator.comparing(Book::getName);
		}
		
		if(sortRule.equalsIgnoreCase("desc")) {
			comparator = comparator.reversed();
		}
		
		return comparator;
	}
	
	public Book insert(Book requestBook) {
		if(find(requestBook.getId()).isPresent()) {
			throw new DuplicatedException("The book id already exists");
		}
		
		Book newBook = new Book();
		newBook.setId(requestBook.getId());
		newBook.setIsbn(requestBook.getIsbn());
		newBook.setName(requestBook.getName());
		newBook.setAuthor(requestBook.getAuthor());
		newBook.setPublisher(requestBook.getPublisher());
		newBook.setPublishYear(requestBook.getPublishYear());
		newBook.setPrice(requestBook.getPrice());
		
		bookDB.add(newBook);
		return newBook;
	}
	
	public Book replace(int id, Book requestBook) {
		Optional<Book> bookOp = find(id);
		
		bookOp.ifPresent(b -> {
			b.setIsbn(requestBook.getIsbn());
			b.setName(requestBook.getName());
			b.setAuthor(requestBook.getAuthor());
			b.setPublisher(requestBook.getPublisher());
			b.setPublishYear(requestBook.getPublishYear());
			b.setPrice(requestBook.getPrice());
		});
		
		return requestBook;
	}
	
	public void delete(int id) {
		bookDB.removeIf(b -> b.getId() == id);
	}
}
