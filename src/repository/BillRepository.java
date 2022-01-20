package repository;

import java.util.List;

import model.Bill;

public class BillRepository {
	
	public List<Bill> getAll(){
		return new Bill().GetAllBill();
	}
	
	public boolean store(Bill payload) {
		Bill bill = new Bill();
		bill.setBill_ID(payload.getBill_ID());
		bill.setEmployeeID(payload.getEmployeeID());
		bill.setPatientID(payload.getPatientID());
		bill.setPaymentType(payload.getPaymentType());
		bill.setStatus(payload.getStatus());
		bill.setDateTimeCreated(payload.getDateTimeCreated());
		
		return bill.insertBill();
	}

}
