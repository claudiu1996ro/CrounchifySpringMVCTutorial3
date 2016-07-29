package com.crunchify.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crunchify.model.customer.dao.CustomerDAO;
import com.crunchify.model.customer.model.Customer;



/*
 * author: Crunchify.com
 * 
 */

@Controller
public class CrunchifyHelloWorld {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	@RequestMapping("/customer")
	public ModelAndView createCustomer() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Customer customer = new Customer(1, "mkyong", 28);
		customerDAO.insert(customer);

		Customer customer1 = customerDAO.findByCustomerId(2);
//		System.out.println(customer1);
		
		String message = "<br><div style='text-align:center;'>"
				+ customer1.toString() + "</div><br><br>";
		return new ModelAndView("customer", "message", message);

	}
}