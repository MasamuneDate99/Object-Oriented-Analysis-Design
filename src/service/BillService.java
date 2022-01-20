package service;

import java.util.List;

import model.Bill;
import repository.BillRepository;

public class BillService {
	
	private BillRepository repository = new BillRepository();
	
	public List<Bill> getAll(){
		return repository.getAll();
	}
	
	public boolean save(Bill payload) {
		return repository.store(payload);
	}

}
