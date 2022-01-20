package repository;

import java.util.List;

import model.Role;

public class RoleRepository {
	public List<Role> getAll(){
		return new Role().GetAllRole();
	}
}
