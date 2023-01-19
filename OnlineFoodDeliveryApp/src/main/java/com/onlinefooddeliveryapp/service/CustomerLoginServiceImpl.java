package com.onlinefooddeliveryapp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.CustomerLoginException;
import com.onlinefooddeliveryapp.model.CurrentCustomerSession;
import com.onlinefooddeliveryapp.model.Customer;
import com.onlinefooddeliveryapp.model.CustomerLoginDTO;
import com.onlinefooddeliveryapp.repository.CustomerRepository;
import com.onlinefooddeliveryapp.repository.CustomerSessionRepository;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
	
	
	@Autowired
	private CustomerRepository cRepository;
	
	@Autowired
	private CustomerSessionRepository csRepository;

	@Override
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException {
		Customer existingCustomer = cRepository.findByEmail(dto.getEmail());
		if (existingCustomer == null) {
			throw new CustomerLoginException("Please enter a correct email");
		}
		
		Optional<CurrentCustomerSession> validCustomerSessionOpt = csRepository.findById(existingCustomer.getCustomerId());
		
		if (validCustomerSessionOpt.isPresent()) {
			throw new CustomerLoginException("Customer already Logged In with this email");
		}
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		if (existingCustomer.getMobile().equals(dto.getMobile())) {
			String key = "";
			int len = 8;
			
			while (len-- != 0) {
				int index = (int) (Math.random() * characters.length());
				key+= characters.charAt(index);
			}
			
			CurrentCustomerSession currentCustomerSession = new CurrentCustomerSession(existingCustomer.getCustomerId(), key, LocalDateTime.now());
			csRepository.save(currentCustomerSession);
			return currentCustomerSession.toString();
		}
		throw new CustomerLoginException("Please Enter a valid password");
	}

	@Override
	public String customerLogout(String key) throws CustomerLoginException {
		
		CurrentCustomerSession currentCustomerSession = csRepository.findByCustomerUniqueId(key);
		
		if (currentCustomerSession == null) {
			throw new CustomerLoginException("Customer not logged In!");
		}
		
		csRepository.delete(currentCustomerSession);
		
		return "Customer successfully logged out!";
	}

}
