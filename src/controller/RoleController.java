package controller;

import java.util.List;

import model.Role;
import service.RoleService;

public class RoleController {
	private RoleService service = new RoleService();
	
	public List<Role> index(){
		return service.getAll();
	}
	
}
