package com.onlinefooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.CustomerException;
import com.onlinefooddeliveryapp.model.Customer;
import com.onlinefooddeliveryapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository cRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		return cRepository.save(customer);
	}

	@Override
	public Customer updateCustomerByCustomerId(Customer customer) throws CustomerException {
		Optional<Customer> opt = cRepository.findById(customer.getCustomerId());
		Customer existingCustomer = opt.get();
		if (existingCustomer.getCustomerId().equals(customer.getCustomerId())) {
			return cRepository.save(customer);
		}
		throw new CustomerException("No such customer exist with the data");
	}

	@Override
	public Customer removeCustomerByCustomerId(Integer customerId) throws CustomerException {
		Optional<Customer> opt = cRepository.findById(customerId);
		Customer existingCustomer = opt.get();
		if (existingCustomer.getCustomerId() == customerId) {
			cRepository.delete(existingCustomer);
			return existingCustomer;
		}else {
		throw new CustomerException("Customer does not exist with customerId : " +customerId);
	}
	}

	@Override
	public Customer viewCustomerByCustomerId(Integer customerId) throws CustomerException {
		
		return cRepository.findById(customerId).orElseThrow(() -> new CustomerException("Customer does not exist with customerId : " +customerId));
		
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
	    List<Customer> listOfCustomers = cRepository.findAll();
	    if (listOfCustomers != null) {
			return listOfCustomers;
		}
	    throw new CustomerException("No customer is exits");
		
	}

}
