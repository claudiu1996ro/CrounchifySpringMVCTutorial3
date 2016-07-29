package com.crunchify.model.customer.dao;

import com.crunchify.model.customer.model.Customer;

public interface CustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}




