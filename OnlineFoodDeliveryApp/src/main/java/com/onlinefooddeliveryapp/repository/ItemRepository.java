package com.onlinefooddeliveryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinefooddeliveryapp.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("from Item i where i.category.categoryName=?1")
	public List<Item> viewAllItemsByCategoryName(String categoryName);
	
	@Query("select r.itemList from Restaurant r where r.restaurantName=?1")
	public List<Item> viewAllItemsByrestaurantName(String restaurantName);

}
