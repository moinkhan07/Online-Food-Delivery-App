package com.onlinefooddeliveryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefooddeliveryapp.exception.CustomerLoginException;
import com.onlinefooddeliveryapp.model.CustomerLoginDTO;
import com.onlinefooddeliveryapp.service.CustomerLoginService;


@RestController
public class CustomerLoginController {
	
	@Autowired
	private CustomerLoginService customerLoginService;
	
	 static boolean flag = false;
	
	@PostMapping("/logincustomer")
	public ResponseEntity<String> loginAsCustomer(@RequestBody CustomerLoginDTO dto) throws CustomerLoginException{
		
		String result = customerLoginService.customerLogin(dto);
		if (result.equals("Login Successfully!")) {
			flag = true;
		}
		return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/logoutcustomer/{cuid}")
	public ResponseEntity<String> logoutAsCustomer(@PathVariable("cuid") String customerUniqueId) throws CustomerLoginException{
		
		String result = customerLoginService.customerLogout(customerUniqueId);	
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}

}
