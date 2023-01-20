package com.onlinefooddeliveryapp.service;

import java.util.List;

import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException;
	
	public Restaurant removeRestaurantById(Integer restaurantId) throws RestaurantException;
	
	public Restaurant viewRestaurantById(Integer restaurantId) throws RestaurantException;
	
	public Restaurant viewRestaurantByRestaurantName(String itemName) throws RestaurantException;
	
	public List<Restaurant> viewRestaurantByLocation(String city) throws RestaurantException;

}
