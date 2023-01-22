package com.onlinefooddeliveryapp.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Size(min = 3,max = 12,message = "FirstName should be between 3-12 characters")
	private String firstName;
	
	@Size(min = 3,max = 10,message = "LastName should be between 3-10 characters")
	private String lastName;
	
	@Min(value = 15,message = "Age should be greater than 15")
	private Integer age;
	
	@NotNull(message = "Gender should not be null")
	private String gender;
	
	@Size(min = 10,max = 10,message = "Mobile Number should be 10 digits")
	private String mobile;
	
	@Email(message = "Please enter correct form of email")
	@Size(min = 10,message = "Email length should be greatert than 10 character")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
}
