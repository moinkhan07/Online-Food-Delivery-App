package com.onlinefooddeliveryapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentCustomerSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
	private String customerUniqueId;
	private LocalDateTime localDateTime;

}
