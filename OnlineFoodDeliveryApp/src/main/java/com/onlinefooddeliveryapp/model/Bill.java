package com.onlinefooddeliveryapp.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billId;
	
	@NotNull(message = "Bill Date should not be null")
	private LocalDateTime billdate;
	
	@NotNull(message = "Total Item should not be null")
	private Integer totalItem;
	
	@NotNull(message = "Total cost should not be null")
	private double totalCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails orderDetails;

}
