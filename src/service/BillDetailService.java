package service;

import java.util.List;

import model.BillDetail;
import repository.BillDetailRepository;

public class BillDetailService {
	private BillDetailRepository repository = new BillDetailRepository();
	
	public List<BillDetail> getAll(){
		return repository.getAll();
	}
	
	public boolean save(BillDetail payload) {
		return repository.save((payload));
	}
}
