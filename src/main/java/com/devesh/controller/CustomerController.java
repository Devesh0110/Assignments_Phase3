package com.devesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devesh.dao.CustomerDao;
import com.devesh.model.*;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao obj;

	@RequestMapping(value = "/list-customer", method = RequestMethod.GET)
	public ModelAndView listCustomer() {
		ModelAndView mv = new ModelAndView("list-customer");
		List<Customer> list = obj.getProducts();
		mv.addObject("list", list);
		return mv;
	}

	// load add product
	@RequestMapping(value = "/add-customer", method = RequestMethod.GET)
	public ModelAndView addCustomer() {
		ModelAndView mv = new ModelAndView("add-customer");
		Customer p = new Customer();
		mv.addObject("customer", p);
		return mv;
	}

	@RequestMapping(value = "/add-customer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer product) {
		ModelAndView mv = new ModelAndView("success-response");
		obj.addProduct(product);
		mv.addObject("action", "created");
		return mv;
	}

	// load update product
	@RequestMapping(value = "/update-customer", method = RequestMethod.GET)
	public ModelAndView updateCustomer() {
		ModelAndView mv = new ModelAndView("update-customer");
		Customer product = new Customer();
		mv.addObject("customer2", product);
		return mv;
	}

	@RequestMapping(value = "/update-customer", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute("customer2") Customer product) {
		ModelAndView mv = new ModelAndView("success-response");
		obj.updateProduct(product);
		mv.addObject("action", "updated");
		return mv;
	}
	
	

	// load delete product
	@RequestMapping(value = "/delete-customer", method = RequestMethod.GET)
	public ModelAndView deleteProduct() {
		ModelAndView mv = new ModelAndView("delete-customer");
		Customer product = new Customer();
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(value = "/delete-customer", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute("product") Customer product) {
		ModelAndView mv = new ModelAndView("success-response");
		obj.deleteProduct(product);
		mv.addObject("action", "deleted");
		return mv;
	}

}