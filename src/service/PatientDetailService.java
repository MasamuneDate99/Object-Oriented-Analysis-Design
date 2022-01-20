package service;

import java.util.List;

import model.PatientDetail;
import repository.PatientDetailRepository;

public class PatientDetailService {
	private PatientDetailRepository repository = new PatientDetailRepository();

	public List<PatientDetail> getAll() {
		return repository.getAll();
	}

	public boolean save(PatientDetail payload) {
		return repository.save(payload);
	}

}
