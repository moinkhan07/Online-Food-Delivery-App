package com.onlinefooddeliveryapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.CustomerException;
import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.Customer;
import com.onlinefooddeliveryapp.model.Item;
import com.onlinefooddeliveryapp.model.Restaurant;
import com.onlinefooddeliveryapp.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
		Restaurant existingRestaurant = restaurantRepository.findByRestaurantName(restaurant.getRestaurantName());
		if (existingRestaurant != null) {
			throw new RestaurantException("Restaurant already exist");
		}
		return restaurantRepository.save(restaurant);
		
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurant.getRestaurantId());
		Restaurant existingRestaurant = opt.get();
		if (existingRestaurant.getRestaurantId().equals(restaurant.getRestaurantId())) {
			return restaurantRepository.save(restaurant);
		}
		throw new RestaurantException("No such restaurant exist with the data");
	}

	@Override
	public Restaurant removeRestaurantById(Integer restaurantId) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
		Restaurant existingRestaurant = opt.get();
		if (existingRestaurant.getRestaurantId() == restaurantId) {
			 restaurantRepository.delete(existingRestaurant);
			 return existingRestaurant;
		}
		throw new RestaurantException("No such restaurant exist with the data");
	}

	@Override
	public Restaurant viewRestaurantById(Integer restaurantId) throws RestaurantException {
		Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);
		Restaurant existingRestaurant = opt.get();
		if (existingRestaurant.getRestaurantId() != restaurantId) {
			throw new RestaurantException("No such restaurant exist with the data");
		}else {
		 return existingRestaurant;
		}
	}

	@Override
	public Restaurant viewRestaurantByRestaurantName(String restaurantName) throws RestaurantException {
		Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName);
		
		if (restaurant != null) {
			return restaurant;
		}
		throw new RestaurantException("No resturant is exist with the reatuarant name " + restaurantName);
	}

	@Override
	public List<Restaurant> viewRestaurantByLocation(String city) throws RestaurantException {
		List<Restaurant> listOfRestaurantsByCity = restaurantRepository.getRestaurantsbylocation(city);	
		if (listOfRestaurantsByCity.isEmpty()) {
			throw new RestaurantException("No restaurants are exist in " + city);
		}else {
			return listOfRestaurantsByCity;
		}
	}

}
