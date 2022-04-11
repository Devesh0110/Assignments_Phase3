package com.simplilearn.webservice.contoller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.exception.InvalidOrderException;
import com.simplilearn.webservice.exception.OrderNotFound;
import com.simplilearn.webservice.repository.OrderRepository;

@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	List<Order> orders = new ArrayList<Order>();

	// get all products
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> getOrders() {
		List<Order> orderList = orderRepository.findAll();
		if (orderList.isEmpty()) {
			throw new OrderNotFound("Order not found, Order list is empty");
		}
		return orderList;
	}
//
//	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
//	public Product getProduct(@PathVariable("id") int id) {
//		Optional<Product> productData = productRepository.findById(id);
//		if (productData.isPresent()) {
//			return productData.get();
//		}
//		throw new ProductNotFound("Product not found with given id " + id);
//	}
//
//	@RequestMapping(value = "/product", method = RequestMethod.GET)
//	public List<Product> getProduct(@RequestParam("name") String name) {
//		List<Product> productList = productRepository.findByName(name);
//		if (!productList.isEmpty()) {
//			return productList;
//		}
//		throw new ProductNotFound("Product not found with given name '" + name + "'");
//	}
//	
//	@RequestMapping(value = "/filter/product", method = RequestMethod.GET)
//	public List<Product> filterProduct(@RequestParam("available") boolean available) {
//		List<Product> productList = productRepository.findByIsAvailable(available);
//		if (!productList.isEmpty()) {
//			return productList;
//		}
//		throw new ProductNotFound("Product not found with avaialable status '" + available + "'");
//	}
//
//	@RequestMapping(value = "/search", method = RequestMethod.GET)
//	public List<Product> searchProduct(@RequestParam("name") String name) {
//		List<Product> productList = productRepository.searchByName(name);
//		if (!productList.isEmpty()) {
//			return productList;
//		}
//		throw new ProductNotFound("Product not found with given text '" + name + "'");
//	}
//
	// add Order
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order addOrder(@RequestBody(required = false) Order order) {
		if (order != null) {
			if (order.getName() != null) {
				return orderRepository.save(order);
			} else {
				throw new InvalidOrderException("Order can not be created , required *name filed missing");
			}
		}
		throw new InvalidOrderException("Order can not be created , required fileds missing");
	}
//
	// update Order
	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
	public Order updateOrder(@RequestBody Order order) {
		Optional<Order> OrderData = orderRepository.findById(order.getId());
		if (OrderData.isPresent()) {
			return orderRepository.save(order);
		}
		throw new OrderNotFound("Order not found with given id " + order.getId());
	}
//
	// delete order
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public Order deleteOrder(@PathVariable("id") int id) {
		Optional<Order> orderData = orderRepository.findById(id);
		if (orderData.isPresent()) {
			orderRepository.delete(orderData.get());
			return orderData.get();
		}
		throw new OrderNotFound("Order not found with given id " + id);
	}
}

