package com.onlinefooddeliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinefooddeliveryapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);
	
}
