package com.example.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bookstore.entity.Order;

public interface OrderRecordRepository extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o INNER JOIN o.book bk WHERE o.id = :orderId")
	Optional<Order> getOrderDetails(@Param("orderId") int orderId);
}
