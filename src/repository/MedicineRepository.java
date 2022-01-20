package repository;

import java.util.List;

import model.Medicine;

public class MedicineRepository {
	public List<Medicine> getAll(){
		return new Medicine().GetAllMedicine();
	}
	
	public boolean save(Medicine payload) {
		Medicine medicine = new Medicine();
		medicine.setMedicineID(payload.getMedicineID());
		medicine.setMName(payload.getMName());
		medicine.setMPrice(payload.getMPrice());
		medicine.setMStock(payload.getMStock());
		
		return medicine.insertMedicine();
	}
}
