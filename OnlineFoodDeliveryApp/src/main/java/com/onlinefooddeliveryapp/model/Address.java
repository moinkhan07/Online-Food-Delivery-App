package com.onlinefooddeliveryapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	@NotNull(message = "BuildingName should not be null")
	private String buildingName;
	
	@NotNull(message = "StreetNo should not be null")
	private String streetNo;
	
	@NotNull(message = "City should not be null")
	private String city;
	
	@NotNull(message = "State should not be null")
	private String state;
	
	@NotNull(message = "Pincode should not be null")
	@Size(min = 6,max = 6,message = "Pincode must be of 6 digits")
	private String pincode;

}
