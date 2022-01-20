package service;

import java.util.List;

import model.Medicine;
import repository.MedicineRepository;

public class MedicineService {
	private MedicineRepository repository = new MedicineRepository();

	public List<Medicine> getAll(){
		return repository.getAll();
	}
	
	public boolean save(Medicine payload) {
		return repository.save(payload);
	}
}
