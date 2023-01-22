package com.onlinefooddeliveryapp.service;

import java.util.List;

import com.onlinefooddeliveryapp.exception.CustomerException;
import com.onlinefooddeliveryapp.exception.OrderDetailsException;
import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.OrderDetails;

public interface OrderDetailsService {
	
	public OrderDetails addOrder(OrderDetails order) throws OrderDetailsException;

	public OrderDetails updateOrder(OrderDetails order) throws OrderDetailsException;

	public OrderDetails removeOrder(OrderDetails order) throws OrderDetailsException;

	public OrderDetails viewOrder(OrderDetails order) throws OrderDetailsException;

	public List<OrderDetails> viewAllOrderByCustomerId(Integer customerId) throws OrderDetailsException;


}
