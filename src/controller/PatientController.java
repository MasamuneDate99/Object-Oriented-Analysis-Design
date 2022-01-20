package controller;

import java.util.List;

import model.Patient;
import service.PatientService;

public class PatientController {
	private PatientService service = new PatientService();
	
	public List<Patient> index(){
		return service.getAll();

	}
	
	public boolean create(Patient payload) {
		return service.save(payload);
	}
}
