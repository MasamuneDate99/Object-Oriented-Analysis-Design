package controller;

import java.util.List;

import model.PatientDetail;
import service.PatientDetailService;

public class PatientDetailController {
	private PatientDetailService service = new PatientDetailService();

	public List<PatientDetail> index(){
		return service.getAll();
	}
	
	public boolean create(PatientDetail payload) {
		return service.save(payload);
	}
}
	