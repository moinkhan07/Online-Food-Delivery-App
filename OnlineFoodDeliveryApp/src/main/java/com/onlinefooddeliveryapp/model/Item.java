package com.onlinefooddeliveryapp.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemtId;
	private String itemName;
	private Integer quantity;
	private double cost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "itemList")
	private List<Restaurant> restaurantList = new ArrayList<>();

}
