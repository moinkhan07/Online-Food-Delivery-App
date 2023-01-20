package com.onlinefooddeliveryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinefooddeliveryapp.model.Address;
import com.onlinefooddeliveryapp.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	public Restaurant findByRestaurantName(String rName);
	
	@Query("from Restaurant r where r.address.city=?1")
	public List<Restaurant> getRestaurantsbylocation(String city);
	
}
