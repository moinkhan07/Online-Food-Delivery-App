package com.onlinefooddeliveryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefooddeliveryapp.exception.FoodCartException;
import com.onlinefooddeliveryapp.exception.ItemException;
import com.onlinefooddeliveryapp.model.FoodCart;
import com.onlinefooddeliveryapp.model.Item;
import com.onlinefooddeliveryapp.service.FoodCartService;

@RestController
public class FoodCartController {
	
	@Autowired
	private FoodCartService foodCartService;
	
	@PostMapping("/foodcarts")
	public ResponseEntity<FoodCart> addFoodCart(@RequestBody FoodCart foodCart) throws FoodCartException{
		FoodCart savedFoodCart = foodCartService.saveFoodCart(foodCart);
		return new ResponseEntity<>(savedFoodCart,HttpStatus.CREATED);
	}
	
	@PutMapping("/foodcarts/{fcid}")
	public ResponseEntity<FoodCart> addItemToFoodCart(@RequestBody Item item, @PathVariable("fcid") Integer fcid) throws FoodCartException, ItemException{
		FoodCart existingFoodCart = foodCartService.addItemToFoodCart(fcid, item);
	    return new ResponseEntity<>(existingFoodCart,HttpStatus.OK);
	}
	
	@PutMapping("/foodcartsincreasequantity/{fcId}/{quantity}")
	public  ResponseEntity<FoodCart> increaseQuantityOfItem(@RequestBody() Item item, @PathVariable("fcId") Integer foodCartId,@PathVariable("quantity") Integer quantity) throws FoodCartException, ItemException{
		FoodCart updatedFoodCart = foodCartService.IncreaseQuantity(foodCartId, item,quantity);
		return new ResponseEntity<FoodCart>(updatedFoodCart,HttpStatus.OK);
	}
	
	@PutMapping("/foodcartsdecreasequantity/{fcId}/{quantity}")
	public  ResponseEntity<FoodCart> descreaseQuantityOfItem(@RequestBody Item item, @PathVariable("fcId") Integer foodCartId,@PathVariable("quantity") Integer quantity) throws FoodCartException, ItemException{
		FoodCart updatedFoodCart = foodCartService.reduceQuantity(foodCartId, item,quantity);
		return new ResponseEntity<FoodCart>(updatedFoodCart,HttpStatus.OK);
	}

	
	@DeleteMapping("/foodcarts/{foodcartId}/{itemId}")
	public ResponseEntity<FoodCart> removeItemFromFoodCart(@PathVariable("foodcartId") Integer foodCartId, @PathVariable("itemId") Integer itemId) throws FoodCartException, ItemException{
		FoodCart deletedItemCart = foodCartService.removeItem(foodCartId, itemId);
		return new ResponseEntity<FoodCart>(deletedItemCart,HttpStatus.OK);
	}
	
	@DeleteMapping("/foodcarts")
	public ResponseEntity<FoodCart> clearFoodCart(@RequestBody FoodCart foodCart) throws FoodCartException{
		FoodCart clearedFoodCart = foodCartService.clearFoodCart(foodCart);
		return new ResponseEntity<FoodCart>(clearedFoodCart,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
