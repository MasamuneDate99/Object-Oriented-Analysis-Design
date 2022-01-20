package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class Employee {
	private int EmployeeID, RoleID;
	private String Name, Username, Password;
	private int Salary;
	private String Status;
	private String table = "employee";
	private Connect con = Connect.getConnection();

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeID, int roleID, String name, String username, String password, int salary,
			String status) {
		EmployeeID = employeeID;
		RoleID = roleID;
		Name = name;
		Username = username;
		Password = password;
		Salary = salary;
		Status = status;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getRoleID() {
		return RoleID;
	}

	public void setRoleID(int roleID) {
		RoleID = roleID;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	// load role
	public Vector<Employee> GetAllEmployee() {
		String query = String.format("SELECT * FROM %s", this.table);

		// menampung hasil dari select
		ResultSet rs = con.executeQuery(query);

		// return data dari db
		Vector<Employee> listEmployee = new Vector<>();

		// looping masukkin data ke vector
		try {
			while (rs.next()) {
				int employeeID = rs.getInt("EmployeeID");
				int roleID = rs.getInt("RoleID");
				String name = rs.getString("Name");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				int salary = rs.getInt("Salary");
				String status = rs.getString("Status");

				listEmployee.add(new Employee(employeeID, roleID, name, username, password, salary, status));
			}
			return listEmployee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// insert object
	public boolean insertEmployee() {
		String query = String.format("INSERT INTO %s Values (NULL,?,?,?,?,?,?)", this.table);

		PreparedStatement ps = con.prepareStatement(query);

		try {
			ps.setString(2, Name);
			ps.setString(3, Username);
			ps.setString(4, Password);
			ps.setInt(5, Salary);
			ps.setString(6, Status);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
