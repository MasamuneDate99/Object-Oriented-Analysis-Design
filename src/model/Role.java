package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class Role {
	private int RoleID;
	private String RName;
	private String table = "role";
	
	private Connect con = Connect.getConnection();

	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public String getRName() {
		return RName;
	}
	public void setRName(String rName) {
		RName = rName;
	}
	public Role(int roleID, String rName) {
		RoleID = roleID;
		RName = rName;
	}

	//load role
	public Vector<Role> GetAllRole(){
		String query = String.format("SELECT * FROM %s", this.table);
		
		//menampung hasil dari select
		ResultSet rs = con.executeQuery(query);
		
		//return data dari db 
		Vector<Role> listRole = new Vector<>();
		
		//looping masukkin data ke vector
		try {
			while(rs.next()) {
				int roleID = rs.getInt("RoleID");
				String rName = rs.getString("RName");
				
				listRole.add(new Role(roleID, rName));			
			}
		return listRole;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public Role getRole(int role) {
//		String query = String.format("SELECT * FROM role Where id = ?", this.table);
//		PreparedStatement ps = con.prepareStatement(query);
//		ResultSet rs = con.executeQuery(query);
//		
//		
//	}
}
