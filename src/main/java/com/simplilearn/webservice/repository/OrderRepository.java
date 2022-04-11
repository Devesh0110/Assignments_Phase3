package com.simplilearn.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.webservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	// Derived Query Methods in Spring boot
	List<Order> findByName(String name);
	
	List<Order> findByPrice(double price);
	
	List<Order> findByDescription(String desc);
}
	
