package controller;

import java.util.List;

import model.Employee;
import service.EmployeeService;

public class EmployeeController {
	private EmployeeService service = new EmployeeService();
	
	public List<Employee> index(){
		return service.getAll();
	}
	
	public boolean create(Employee payload) {
		return service.save(payload);
	}
}
