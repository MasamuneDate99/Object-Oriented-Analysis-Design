package controller;

import java.util.List;

import model.Medicine;
import service.MedicineService;

public class MedicineController {
	private MedicineService service = new MedicineService();

	public List<Medicine> index(){
		return service.getAll();
	}
	
	public boolean create(Medicine payload) {
		return service.save(payload);
	}
}

