package com.onlinefooddeliveryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefooddeliveryapp.exception.BillException;
import com.onlinefooddeliveryapp.model.Bill;
import com.onlinefooddeliveryapp.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@PostMapping("/bills")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws BillException{
		Bill savedBill = billService.addBill(bill);
		return new ResponseEntity<Bill>(savedBill,HttpStatus.CREATED);
	}
	
	@PutMapping("/bills")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException{
		Bill updatedBill = billService.updateBill(bill);
		return new ResponseEntity<Bill>(updatedBill,HttpStatus.OK);
	}
	
	@DeleteMapping("/bills/{billId}")
	public ResponseEntity<Bill> deleteBillByBillId(@PathVariable("billId") Integer billId) throws BillException{
		Bill deletedBill = billService.removeBill(billId);
		return new ResponseEntity<Bill>(deletedBill,HttpStatus.OK);
	}
	
	@GetMapping("/bills/{billId}")
	public ResponseEntity<Bill> viewBillByBillId(@PathVariable("billId") Integer billId) throws BillException {
		Bill existingBill = billService.viewsBill(billId);
		return new ResponseEntity<Bill>(existingBill,HttpStatus.OK);
	}
	
	@GetMapping("/bills")
	public ResponseEntity<Double> calculateTotalCost(@RequestBody Bill bill) throws BillException {
		Double totalCost = billService.calculateTotalCost(bill);
		return new ResponseEntity<Double>(totalCost, HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
