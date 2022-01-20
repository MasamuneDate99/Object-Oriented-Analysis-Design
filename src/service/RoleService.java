package service;

import java.util.List;

import model.Role;
import repository.RoleRepository;

public class RoleService {
	private RoleRepository repository = new RoleRepository();
	
	public List<Role> getAll(){
		return repository.getAll();
	}
	
}
