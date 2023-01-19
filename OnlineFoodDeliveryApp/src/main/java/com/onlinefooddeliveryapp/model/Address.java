package com.onlinefooddeliveryapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
