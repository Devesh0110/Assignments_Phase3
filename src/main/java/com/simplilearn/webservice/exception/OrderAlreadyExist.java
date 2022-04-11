package com.simplilearn.webservice.exception;

public class OrderAlreadyExist extends RuntimeException {
	private static final long serialVersionUID = 1L;
public OrderAlreadyExist(String m) {
	super(m);
}
}
