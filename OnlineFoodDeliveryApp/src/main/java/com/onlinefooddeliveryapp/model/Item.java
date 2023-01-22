package com.onlinefooddeliveryapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	
	@NotNull(message = "Item Name should not be null")
	@Size(min = 5,max = 15,message = "Item Name should between 5 to 15 characters")
	private String itemName;
	
	@NotNull(message = "Quantity should not be null")
	private Integer quantity;
	
	@NotNull(message = "Cost should not be null")
	private double cost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "itemList")
	@JsonIgnore
	private List<Restaurant> restaurantList = new ArrayList<>();

}
