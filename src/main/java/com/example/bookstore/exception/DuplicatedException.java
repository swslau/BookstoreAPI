package com.example.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedException extends RuntimeException {
	public DuplicatedException() {
		super();
	}
	
	public DuplicatedException(String message) {
		super(message);
	}
}
