package repository;

import java.util.List;

import model.Patient;

public class PatientRepository {
	public List<Patient> getAll() {
		return new Patient().GetAllPatient();
	}

	public boolean save(Patient payload) {
		Patient patient = new Patient();
		patient.setDOB(payload.getDOB());
		patient.setName(payload.getName());
		patient.setPatientID(payload.getPatientID());
	
		return patient.insertPatient();
	}
}
