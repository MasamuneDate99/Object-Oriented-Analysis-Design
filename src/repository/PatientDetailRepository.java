package repository;

import java.util.List;

import model.PatientDetail;

public class PatientDetailRepository {
	public List<PatientDetail> getAll(){
		return new PatientDetail().GetAllPatientDetail();
	}
	
	public boolean save(PatientDetail payload) {
		PatientDetail patientDetail = new PatientDetail();
		
		patientDetail.setCheckDate(payload.getCheckDate());
		patientDetail.setEmployeeID(payload.getEmployeeID());
		patientDetail.setPatientDetailID(payload.getPatientDetailID());
		patientDetail.setPatientID(payload.getPatientID());
		patientDetail.setSymptom(payload.getSymptom());
		
		return patientDetail.insertPatientDetail();
	}
}
