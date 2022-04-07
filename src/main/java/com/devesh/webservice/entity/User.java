package com.devesh.webservice.entity;


import java.util.Date;

public class User {

	// properties
	private int id;
	private String name;
	private int age;
	private String description;
	private boolean isAdmin;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public User(int id, String name, int age, String description, boolean isAdmin, Date createAt) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.description = description;
		this.isAdmin = isAdmin;
		this.createAt = createAt;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
