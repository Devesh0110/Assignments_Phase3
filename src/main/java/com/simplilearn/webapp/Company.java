package com.simplilearn.webapp;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.simplilearn.bean.Employee;

public class Company {

	public static void main(String[] args) {
		
		// Tightly coupled object
		// create employee object
		// Employee employee  = new Employee();
		
		// initialize properties
		// employee.setId(1001);
		// employee.setName("John Smith");
		// employee.setDept("Engineering");
		// employee.setSalary(45646.654);
		// System.out.println(employee);
		
		// Spring IOC : Inversion of control => DI  dependency Injection.
		
		// 1. Application Context container
		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
		
		Employee emp1 = (Employee) context.getBean("emp1");		
		Employee emp2 = context.getBean("emp2",Employee.class);
		
		System.out.println(emp1);
		System.out.println(emp2);
		
		System.out.println("------------------------");
		
		// 2. Bean Factory Container
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("employeebean.xml"));
		
		Employee employee1 = (Employee)beanFactory.getBean("emp1");
		
		Employee employee2 = beanFactory.getBean("emp2", Employee.class);
		
		System.out.println(employee1);
		System.out.println(employee2);
		
	}

}