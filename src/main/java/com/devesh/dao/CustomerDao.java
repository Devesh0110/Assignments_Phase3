package com.devesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.devesh.model.Customer;

public class CustomerDao {
	
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// list all products
	public List<Customer> getProducts() {
		String READ_PRODUCT ="select * from customer_data";
		List<Customer> productsList = template.query(READ_PRODUCT, new RowMapper<Customer>() {
			// map result set row value to product object
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer product = new Customer();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setAge(rs.getInt(3));
				product.setCreatedAt(rs.getDate(4));
				return product;
			}
		});
		return productsList;
	}
	
	// create product
	public int addProduct(Customer product) {
		String ADD_PRODUCT = "insert into customer_data(name, age) values (?, ?)";
		return template.update(ADD_PRODUCT,product.getName(), product.getAge());
	}
	
	// update product
	public int updateProduct(Customer product) {
		String UPDATE_PRODUCT = "UPDATE customer_data set name=?, age=? where id=?";
		return template.update(UPDATE_PRODUCT,product.getName(), product.getAge(), product.getId());
	}
	
	// delete product
	public int deleteProduct(Customer product) {
		String DELETE_PRODUCT = "delete from customer_data where id=?";
		return template.update(DELETE_PRODUCT,product.getId());
	}
	
}