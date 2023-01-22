package com.onlinefooddeliveryapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefooddeliveryapp.exception.BillException;
import com.onlinefooddeliveryapp.model.Bill;
import com.onlinefooddeliveryapp.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill addBill(Bill bill) throws BillException {
		return billRepository.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
	Optional<Bill> opt = billRepository.findById(bill.getBillId());
	Bill existingBill = opt.get();
	if (existingBill.getBillId().equals(bill.getBillId())) {
		billRepository.save(bill);
		return existingBill;
	}
		throw new BillException("No such bill is available");
	}

	@Override
	public Bill removeBill(Integer billId) throws BillException {
		Optional<Bill> opt = billRepository.findById(billId);
		Bill existingBill = opt.get();
		if (existingBill.getBillId() == billId) {
			billRepository.delete(existingBill);
			return existingBill;
		}
			throw new BillException("No such bill is available with the billId " + billId);
	}

	@Override
	public Bill viewsBill(Integer billId) throws BillException {
		Optional<Bill> opt = billRepository.findById(billId);
		Bill existingBill = opt.get();
		if (existingBill.getBillId() == billId) {
			return existingBill;
		}
			throw new BillException("No such bill is available with the billId " + billId);
	}

	@Override
	public Double calculateTotalCost(Bill bill) throws BillException {
		Optional<Bill> optBill = billRepository.findById(bill.getBillId());
		if (optBill.isPresent()) {
			Bill existingBill = optBill.get();
			Double totalCost = existingBill.getTotalCost();
			return totalCost;
		}
		throw new BillException("No such bill is available");
	}

}
