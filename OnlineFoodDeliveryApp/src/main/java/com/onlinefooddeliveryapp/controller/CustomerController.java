package com.onlinefooddeliveryapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefooddeliveryapp.exception.CustomerException;
import com.onlinefooddeliveryapp.model.Customer;
import com.onlinefooddeliveryapp.service.CustomerService;

import jakarta.validation.Valid;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		Customer savedCustomer = cService.addCustomer(customer);
		return new ResponseEntity<Customer>(savedCustomer,HttpStatus.CREATED);
	}

	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomerByCustomerId(@Valid @RequestBody Customer customer) throws CustomerException{
		Customer updateCustomer = cService.updateCustomerByCustomerId(customer);
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{cid}")
	public ResponseEntity<Customer> removeCustomerByCustomerId(@PathVariable("cid") Integer customerId) throws CustomerException{
		Customer deletedCustomer = cService.removeCustomerByCustomerId(customerId);
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/{cid}")
	public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable("cid") Integer customerId) throws CustomerException{
		Customer existingCustomer = cService.viewCustomerByCustomerId(customerId);
		return new ResponseEntity<Customer>(existingCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws CustomerException{
		
		List<Customer> listOfCustomers = cService.viewAllCustomer();
		return new ResponseEntity<List<Customer>>(listOfCustomers,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
