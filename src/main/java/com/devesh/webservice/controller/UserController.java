package com.devesh.webservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.webservice.entity.User;

@RestController
public class UserController {

	List<User> users = new ArrayList<User>();

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getProducts() {
		if (users.isEmpty()) {
			addDefaultData();
		}
		return users;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int id) {
		for (User product : users) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getProduct(@RequestParam("name") String name) {
		for (User product : users) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public User searchUser(@RequestParam("name") String name) {
		for (User product : users) {
			if (product.getName().contains(name)) {
				return product;
			}
		}
		return null;
	}

	// add product
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public List<User> addProduct(@RequestBody User product) {
		users.add(product);
		return users;
	}

	// update product
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public User updateProduct(@RequestBody User product) {
		for (int index = 0; index < users.size(); index++) {
			if(users.get(index).getId()== product.getId()) {
				users.set(index, product);
				return product;
			}
		}
		return null;
	}
	
	// delete product
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public User deleteProduct(@PathVariable("id") int id) {
		for (int index = 0; index < users.size(); index++) {
			if(users.get(index).getId()== id) {
				User remove =users.get(index);
				users.remove(remove);
				return remove;
			}
		}
		return null;
	}
	
	//add default data when list is empty
	private void addDefaultData() {
		users.add(new User(1, "Devesh", 20, "I am user", true, new Date()));
	}
}

