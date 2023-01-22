package com.onlinefooddeliveryapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.FoodCartException;
import com.onlinefooddeliveryapp.exception.ItemException;
import com.onlinefooddeliveryapp.model.Customer;
import com.onlinefooddeliveryapp.model.FoodCart;
import com.onlinefooddeliveryapp.model.Item;
import com.onlinefooddeliveryapp.repository.CustomerRepository;
import com.onlinefooddeliveryapp.repository.FoodCartRepository;
import com.onlinefooddeliveryapp.repository.ItemRepository;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class FoodCartServiceImpl implements FoodCartService{
	
	@Autowired
	private FoodCartRepository foodCartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public FoodCart saveFoodCart(FoodCart foodCart) throws FoodCartException {
		return foodCartRepository.save(foodCart);
	}
	 Item newItem;
	@Override
	public FoodCart addItemToFoodCart(Integer foodCartId, Item item) throws FoodCartException, ItemException {
		Optional<FoodCart> opt = foodCartRepository.findById(foodCartId); 
		if (opt.isPresent()) {
			FoodCart existingFoodCart =  opt.get();
			existingFoodCart.getItemList().add(item);
			return foodCartRepository.save(existingFoodCart);
		}
		throw new FoodCartException("No such food cart exist with the foodcartid " + foodCartId);
	}

	@Override
	public FoodCart IncreaseQuantity(Integer foodCartId, Item item, Integer quantity)throws FoodCartException, ItemException {
		Optional<FoodCart> opt = foodCartRepository.findById(foodCartId); 
		if (opt.isPresent()) {
			FoodCart existinFoodCart = opt.get();

	List<Item> item3=existinFoodCart.getItemList().stream().filter(i-> i.getItemId()==item.getItemId()).collect(Collectors.toList());
			               item3.forEach(i->{
			            	   i.setQuantity(i.getQuantity()+quantity);
			               });
			                FoodCart foodCart=  foodCartRepository.save(existinFoodCart);
			                return foodCart;
		}
		throw new FoodCartException("No such food cart exist with the foodcartid " + foodCartId);
	}

	@Override
	public FoodCart reduceQuantity(Integer foodCartId, Item item, Integer quantity)throws FoodCartException, ItemException {
		Optional<FoodCart> opt = foodCartRepository.findById(foodCartId); 
		if (opt.isPresent()) {
			FoodCart existinFoodCart = opt.get();

	List<Item> item3=existinFoodCart.getItemList().stream().filter(i-> i.getItemId()==item.getItemId()).collect(Collectors.toList());
			               item3.forEach(i->{
			            	   i.setQuantity(i.getQuantity()-quantity);
			               });
			                FoodCart foodCart=  foodCartRepository.save(existinFoodCart);
			                return foodCart;
		}
		throw new FoodCartException("No such food cart exist with the foodcartid " + foodCartId);
	}

	@Override
	public FoodCart removeItem(Integer foodCartId, Integer itemId) throws FoodCartException, ItemException {
		
		Optional<FoodCart> opt = foodCartRepository.findById(foodCartId); 
		if (opt.isPresent()) {
			FoodCart fCart = opt.get();
			
		    fCart.getItemList().forEach(i->{
		    if(	i.getItemId()==itemId) {
		    	newItem=i;
		    };
		    });
		         foodCartRepository.delete(fCart);
		         itemRepository.save(newItem);
			return fCart;
		}
		throw new FoodCartException("No such food cart exist with the foodcartid " + foodCartId);
	}

	@Override
	public FoodCart clearFoodCart(FoodCart foodCart) throws FoodCartException {
		Optional<FoodCart> opt = foodCartRepository.findById(foodCart.getFoodCartId());
		if (opt.isPresent()) {
			FoodCart deletedFoodCart = opt.get();
			foodCartRepository.delete(foodCart);
			return deletedFoodCart;
		}else {
			throw new FoodCartException("Food Cart Is Empty!");
		}
	}



	
	
}
