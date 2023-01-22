package com.onlinefooddeliveryapp.service;

import java.time.LocalDate;
import java.util.List;

import com.onlinefooddeliveryapp.exception.BillException;
import com.onlinefooddeliveryapp.model.Bill;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill)throws BillException;
	
	public Bill removeBill (Integer billId)throws BillException;
	
	public Bill viewsBill(Integer billId)throws BillException;
	
	public Double calculateTotalCost(Bill bill)throws BillException;

}
