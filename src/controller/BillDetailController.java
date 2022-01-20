package controller;

import java.util.List;

import model.BillDetail;
import service.BillDetailService;

public class BillDetailController {
	private BillDetailService service = new BillDetailService();

	public List<BillDetail> index(){
		return service.getAll();
	}
	
	public boolean create(BillDetail payload) {
		return service.save(payload);
	}
}
