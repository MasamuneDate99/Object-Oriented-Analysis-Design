package repository;

import java.util.List;

import model.Employee;

public class EmployeeRepository {
	public List<Employee> getAll(){
		return new Employee().GetAllEmployee();
	}
	
	public boolean store(Employee payload) {
		Employee employee = new Employee();
		employee.setEmployeeID(payload.getEmployeeID());
		employee.setName(payload.getName());
		employee.setPassword(payload.getPassword());
		employee.setRoleID(payload.getRoleID());
		employee.setSalary(payload.getSalary());
		employee.setStatus(payload.getStatus());
		employee.setUsername(payload.getStatus());
		
		
		return employee.insertEmployee();
	}
}
