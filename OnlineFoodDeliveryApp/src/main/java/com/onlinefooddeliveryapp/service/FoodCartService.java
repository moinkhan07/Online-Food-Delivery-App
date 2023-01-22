package com.onlinefooddeliveryapp.service;

import com.onlinefooddeliveryapp.exception.FoodCartException;
import com.onlinefooddeliveryapp.exception.ItemException;
import com.onlinefooddeliveryapp.model.FoodCart;
import com.onlinefooddeliveryapp.model.Item;

public interface FoodCartService {
	
	public FoodCart saveFoodCart(FoodCart foodCart) throws FoodCartException;
	
	public FoodCart addItemToFoodCart(Integer foodCartId,Item item) throws FoodCartException,ItemException;
	
	public FoodCart IncreaseQuantity(Integer foodCart, Item item,Integer quantity) throws FoodCartException,ItemException;
	
	public FoodCart reduceQuantity(Integer foodCart, Item item, Integer quantity) throws FoodCartException,ItemException;

	public FoodCart removeItem(Integer foodCart,Integer item) throws FoodCartException,ItemException;
	
	public FoodCart clearFoodCart(FoodCart foodCart) throws FoodCartException;
	
}
