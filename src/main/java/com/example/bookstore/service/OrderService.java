package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.entity.Order;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.repository.OrderRecordRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRecordRepository orderRecordRepo;
	
	public Order getOrder(int id) {
		return orderRecordRepo.getOrderDetails(id).orElseThrow(() -> new NotFoundException("Cannot find the book"));
	}
}
