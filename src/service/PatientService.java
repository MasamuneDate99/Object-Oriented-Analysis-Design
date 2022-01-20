package service;

import java.util.List;

import model.Patient;
import repository.PatientRepository;

public class PatientService {
	private PatientRepository repository = new PatientRepository();
	
	public List<Patient> getAll(){
		return repository.getAll();
	}
	
	public boolean save(Patient payload) {
		return repository.save(payload);
	}
}
