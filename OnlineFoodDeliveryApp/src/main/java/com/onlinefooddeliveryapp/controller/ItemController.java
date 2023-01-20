package com.onlinefooddeliveryapp.controller;

import java.util.List;

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

import com.onlinefooddeliveryapp.exception.CategoryException;
import com.onlinefooddeliveryapp.exception.ItemException;
import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.Item;
import com.onlinefooddeliveryapp.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/items/{restId}")
	public ResponseEntity<Item> addItemToRestaurant(@RequestBody Item item, @PathVariable("restId") Integer restId) throws RestaurantException{
		Item savedItem = itemService.addItem(item, restId);
		return new ResponseEntity<Item>(savedItem,HttpStatus.CREATED);
	}
	
	@PutMapping("/items")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ItemException{
		Item updatedItem = itemService.updateItem(item);
		return new ResponseEntity<Item>(updatedItem,HttpStatus.OK);
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<Item> viewItemByItemId(@PathVariable("itemId") Integer itemId) throws ItemException {
		Item existingItem = itemService.viewItem(itemId);
		return new ResponseEntity<>(existingItem,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<Item> removeItemByItemId(@PathVariable("itemId") Integer itemId) throws ItemException {
		Item deletedItem = itemService.removeItem(itemId);
		return new ResponseEntity<>(deletedItem,HttpStatus.OK);
	}
	
	@GetMapping("/itemsbycategoryname/{catName}")
	public ResponseEntity<List<Item>> viewAllItemsBycategoryName(@PathVariable("catName") String categoryName) throws ItemException, CategoryException{
		List<Item> listOfItemsByCategoryName = itemService.viewAllItemByCategoryName(categoryName);
		return new ResponseEntity<List<Item>>(listOfItemsByCategoryName,HttpStatus.OK);
	}
	
	@GetMapping("/itemsbyrestaurantname/{resName}")
	public ResponseEntity<List<Item>> viewAllItemsByRestaurantName(@PathVariable("resName") String restaurantName) throws RestaurantException, ItemException{
		List<Item> listOfItemsByRestaurantName = itemService.viewAllItemsByRestaurantName(restaurantName);
		return new ResponseEntity<List<Item>>(listOfItemsByRestaurantName,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
