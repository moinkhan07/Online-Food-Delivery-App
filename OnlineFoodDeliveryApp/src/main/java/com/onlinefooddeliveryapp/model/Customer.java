package com.onlinefooddeliveryapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
