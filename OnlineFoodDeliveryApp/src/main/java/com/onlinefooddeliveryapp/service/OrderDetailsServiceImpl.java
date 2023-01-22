package com.onlinefooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.OrderDetailsException;
import com.onlinefooddeliveryapp.model.FoodCart;
import com.onlinefooddeliveryapp.model.OrderDetails;
import com.onlinefooddeliveryapp.repository.FoodCartRepository;
import com.onlinefooddeliveryapp.repository.OrderDetailsRepository;
import com.onlinefooddeliveryapp.repository.RestaurantRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private FoodCartRepository foodCartRepository;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderDetailsException {
		return orderDetailsRepository.save(order);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderDetailsException {
		Optional<OrderDetails> optOrder = orderDetailsRepository.findById(order.getOrderId());
		OrderDetails existingOrderDetails = optOrder.get();
		if (existingOrderDetails.getOrderId() == order.getOrderId()) {
			return orderDetailsRepository.save(order);
		}
		throw new OrderDetailsException("Order details not exist");
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws OrderDetailsException {
		Optional<OrderDetails> opt = orderDetailsRepository.findById(order.getOrderId());
		OrderDetails existingOrder = opt.get();
		if (existingOrder.getOrderId().equals(order.getOrderId())) {
			orderDetailsRepository.delete(existingOrder);
			return existingOrder;
		}else {
		throw new OrderDetailsException("Order details does not exist");
	}
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws OrderDetailsException {
		return orderDetailsRepository.findById(order.getOrderId()).orElseThrow(() -> new OrderDetailsException("Order Detail does not exist"));
	}

	@Override
	public List<OrderDetails> viewAllOrderByCustomerId(Integer customerId)throws OrderDetailsException{
		FoodCart foodCart = foodCartRepository.getFoodCartByCustomer(customerId);
		List<OrderDetails> listOfOrders = orderDetailsRepository.getFoodCart(foodCart.getFoodCartId());
		if (listOfOrders.isEmpty()) {
			throw new OrderDetailsException("No order found by customer Id " + customerId);
		}
		return listOfOrders;
	}

}
