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

import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.Restaurant;
import com.onlinefooddeliveryapp.service.RestaurantService;



@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restaurants")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant) throws RestaurantException{
		Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(savedRestaurant,HttpStatus.CREATED);
	}
	
	@PutMapping("/restaurants")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) throws RestaurantException{
		Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
		return new ResponseEntity<>(updatedRestaurant,HttpStatus.OK);
	}
	
	@DeleteMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> removeRestaurant(@PathVariable("id") Integer id) throws RestaurantException{
		Restaurant deletedRestaurant = restaurantService.removeRestaurantById(id);
		return new ResponseEntity<>(deletedRestaurant,HttpStatus.OK);
	}
	
	@GetMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Integer id) throws RestaurantException{
		Restaurant existRestaurant = restaurantService.viewRestaurantById(id);
		return new ResponseEntity<>(existRestaurant,HttpStatus.OK);
	}
	
	@GetMapping("/restaurantsbyname/{resname}")
	public ResponseEntity<Restaurant> viewByRestaurantName(@PathVariable("resname") String resName) throws RestaurantException{
		
		Restaurant restaurant = restaurantService.viewRestaurantByRestaurantName(resName);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.OK);
		
	}
	
	@GetMapping("/restaurantsbycity/{city}")
	public ResponseEntity<List<Restaurant>> getAllRestaurantsByCity(@PathVariable("city") String city) throws RestaurantException{
		List<Restaurant> listOfRestaurants = restaurantService.viewRestaurantByLocation(city);
		return new ResponseEntity<List<Restaurant>>(listOfRestaurants,HttpStatus.OK);
	}
	

}
