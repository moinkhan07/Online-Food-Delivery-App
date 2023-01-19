package com.onlinefooddeliveryapp.service;

import com.onlinefooddeliveryapp.exception.CustomerLoginException;
import com.onlinefooddeliveryapp.model.CustomerLoginDTO;

public interface CustomerLoginService {
	
	public String customerLogin(CustomerLoginDTO dto) throws CustomerLoginException;
	
	public String customerLogout(String key) throws CustomerLoginException;

}
