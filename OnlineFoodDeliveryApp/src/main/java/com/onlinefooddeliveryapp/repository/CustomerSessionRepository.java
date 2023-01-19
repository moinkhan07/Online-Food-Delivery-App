package com.onlinefooddeliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefooddeliveryapp.model.CurrentCustomerSession;

@Repository
public interface CustomerSessionRepository extends JpaRepository<CurrentCustomerSession, Integer>{

	public CurrentCustomerSession findByCustomerUniqueId(String cuid);
	
}
