package com.onlinefooddeliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinefooddeliveryapp.model.FoodCart;
@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{
	
	  @Query("select c from FoodCart c where c.customer.customerId=?1")
	  public FoodCart getFoodCartByCustomer(Integer customerId);

}
