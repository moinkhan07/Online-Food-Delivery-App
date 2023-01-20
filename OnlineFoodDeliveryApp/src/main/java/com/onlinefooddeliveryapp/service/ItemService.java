package com.onlinefooddeliveryapp.service;

import java.util.List;

import com.onlinefooddeliveryapp.exception.CategoryException;
import com.onlinefooddeliveryapp.exception.ItemException;
import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.Item;

public interface ItemService {
	
	 public Item addItem(Item item, Integer restaurantId) throws RestaurantException;
	 
	 public Item updateItem(Item item) throws ItemException;
	 
     public Item viewItem(Integer itemId) throws ItemException;
     
	 public Item removeItem(Integer itemId) throws ItemException;
	 
	 public List<Item> viewAllItemByCategoryName(String categoryName) throws ItemException,CategoryException;
	 
	 public List<Item> viewAllItemsByRestaurantName(String RestaurantName) throws RestaurantException,ItemException;
	 
	 
	 

}
