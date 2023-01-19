package com.onlinefooddeliveryapp.service;

import java.util.List;

import com.onlinefooddeliveryapp.exception.CustomerException;
import com.onlinefooddeliveryapp.model.Customer;


public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomerByCustomerId(Customer customer) throws CustomerException;
	
	public Customer removeCustomerByCustomerId(Integer customerId) throws CustomerException;
	
	public Customer viewCustomerByCustomerId(Integer customerId) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;

}
