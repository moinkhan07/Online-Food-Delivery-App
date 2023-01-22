package com.onlinefooddeliveryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinefooddeliveryapp.model.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{
	
    @Query("select c from OrderDetails c where c.foodCart.foodCartId=?1")
    public List<OrderDetails> getFoodCart(Integer foodCartId);

}
