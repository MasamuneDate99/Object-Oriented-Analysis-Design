package service;

import java.util.List;

import model.Employee;
import repository.EmployeeRepository;

public class EmployeeService {
	private EmployeeRepository repository = new EmployeeRepository();

	public List<Employee> getAll(){
		return repository.getAll();
	}
	
	public boolean save(Employee payload) {
		return repository.store(payload);
	}
}
