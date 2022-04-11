package com.simplilearn.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_data")
public class Order {

	// properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int id;
	
	@Column(name="order_label")
	private String name;
	
	@Column(name="order_price")
	private double price;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="order_desc")
	private String description;
	
	@Column(name="created_at")
	private Date createAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Order(int id, String name, double price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		createAt=new Date();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", createAt=" + createAt + "]";
	}
}
	

