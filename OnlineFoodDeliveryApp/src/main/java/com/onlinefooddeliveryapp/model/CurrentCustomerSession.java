package com.onlinefooddeliveryapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
	private String customerUniqueId;
	private LocalDateTime localDateTime;

}
