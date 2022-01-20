package controller;

import java.util.List;

import model.Bill;
import service.BillService;

public class BillController {
	
	private BillService service = new BillService();

	public List<Bill> index() {
		return service.getAll();
	}

	public boolean create(Bill payload) {
		return service.save(payload);
	}

//	public Bill update() {
//
//	}
//
//	public Bill delete() {
//
//	}

}
