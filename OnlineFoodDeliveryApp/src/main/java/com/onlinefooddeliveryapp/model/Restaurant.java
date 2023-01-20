package com.onlinefooddeliveryapp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	
	@NotNull(message = "Restaurant Name should not be null")
	@Size(min = 5,max = 15,message = "Restaurant Name should between 5 to 15 characters")
	private String restaurantName;
	
	@NotNull(message = "Manager Name should not be null")
	private String managerName;
	
	@NotNull(message = "Contact Number should not be null")
	@Size(min = 10,max = 10,message = "Contact Number should be of 10 digits")
	private String contactNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>();

}
