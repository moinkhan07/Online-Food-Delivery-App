package com.onlinefooddeliveryapp.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.onlinefooddeliveryapp.exception.CustomerLoginException;
import com.onlinefooddeliveryapp.exception.OrderDetailsException;
import com.onlinefooddeliveryapp.model.Customer;
import com.onlinefooddeliveryapp.model.OrderDetails;
import com.onlinefooddeliveryapp.service.OrderDetailsService;

@RestController
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping("/orderdetails")
	public ResponseEntity<OrderDetails> saveOrderDetails(@Valid @RequestBody OrderDetails order) throws OrderDetailsException{
			OrderDetails savedOrder = orderDetailsService.addOrder(order);
			return new ResponseEntity<OrderDetails>(savedOrder,HttpStatus.CREATED);
		}

	@PutMapping("/orderdetails")
	public ResponseEntity<OrderDetails> updateOrderDetails(@RequestBody OrderDetails orderDetails) throws OrderDetailsException{
		OrderDetails updateOrderDetails = orderDetailsService.updateOrder(orderDetails);
		return new ResponseEntity<OrderDetails>(updateOrderDetails,HttpStatus.OK);
	}
	
	@DeleteMapping("/orderdetails")
	public ResponseEntity<OrderDetails> removeOrderDetails(@RequestBody OrderDetails orderDetails) throws OrderDetailsException{
		OrderDetails deletedOrderDetails = orderDetailsService.removeOrder(orderDetails);
		return new ResponseEntity<OrderDetails>(deletedOrderDetails,HttpStatus.OK);
	}
	
	@GetMapping("/orderdetails")
	public ResponseEntity<OrderDetails> viewOrderDetail(@RequestBody OrderDetails orderDetails)throws OrderDetailsException{
		OrderDetails viewOrderDetails = orderDetailsService.viewOrder(orderDetails);
		return new ResponseEntity<OrderDetails>(viewOrderDetails,HttpStatus.OK);
	}
	
	
	@GetMapping("/orderdetails/{cId}")
	public ResponseEntity<List<OrderDetails>> viewAllOrderDetails(@PathVariable("cId") Integer cId) throws OrderDetailsException{
		
		List<OrderDetails> listOfOrders = orderDetailsService.viewAllOrderByCustomerId(cId);
		return new ResponseEntity<List<OrderDetails>>(listOfOrders,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
