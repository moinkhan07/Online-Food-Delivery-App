package com.onlinefooddeliveryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.CategoryException;
import com.onlinefooddeliveryapp.exception.ItemException;
import com.onlinefooddeliveryapp.exception.RestaurantException;
import com.onlinefooddeliveryapp.model.Item;
import com.onlinefooddeliveryapp.model.Restaurant;
import com.onlinefooddeliveryapp.repository.ItemRepository;
import com.onlinefooddeliveryapp.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Item addItem(Item item, Integer restaurantId) throws RestaurantException {
		
		Optional<Restaurant> existingRestaurant = restaurantRepository.findById(restaurantId); 
		
		if (existingRestaurant.isPresent()) {
			existingRestaurant.get().getItemList().add(item);
		   return itemRepository.save(item);
		}
		throw new RestaurantException("No such restaurant exist");
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		
		Optional<Item> existingItem = itemRepository.findById(item.getItemId());
		if (existingItem.isEmpty()) {
			throw new ItemException("Item does not exist");
		}
		return itemRepository.save(item);
	}

	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		Optional<Item> optItem = itemRepository.findById(itemId);
		if (optItem.isEmpty()) {
			throw new ItemException("Item does not exist with the itemId " + itemId);
		}
		Item existingItem = optItem.get();
		return existingItem;
	}

	@Override
	public Item removeItem(Integer itemId) throws ItemException {
		Optional<Item> optItem = itemRepository.findById(itemId);
		if (optItem.isEmpty()) {
			throw new ItemException("Item does not exist with the itemId " + itemId);
		}
		Item existingItem = optItem.get();
	    itemRepository.delete(existingItem);
	    return existingItem;
	}

	@Override
	public List<Item> viewAllItemByCategoryName(String categoryName) throws ItemException, CategoryException {
		
		List<Item> listOfItems = itemRepository.viewAllItemsByCategoryName(categoryName);
		if (listOfItems.isEmpty()) {
			throw new CategoryException("No such category is exist");
		}
		return listOfItems;
	}

	@Override
	public List<Item> viewAllItemsByRestaurantName(String RestaurantName) throws RestaurantException, ItemException {
		
		List<Item> listOfItems = itemRepository.viewAllItemsByrestaurantName(RestaurantName);
		if (listOfItems.isEmpty()) {
			throw new RestaurantException("No such restaurant is exist");
		}
		return listOfItems;
	}
	
	
	
	
	
	
	
	
	
	

}
