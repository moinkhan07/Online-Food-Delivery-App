package com.onlinefooddeliveryapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodCartId;
		
	private Integer customerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>();

}
