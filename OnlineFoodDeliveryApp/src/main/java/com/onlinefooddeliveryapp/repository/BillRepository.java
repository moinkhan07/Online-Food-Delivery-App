package com.onlinefooddeliveryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefooddeliveryapp.model.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}
