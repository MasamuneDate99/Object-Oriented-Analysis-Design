package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class PatientDetail {

	private int PatientDetailID,PatientID, EmployeeID;
	private String Symptom;
	private Date CheckDate;
	private String table = "patient_detail";
	private Connect con = Connect.getConnection();
	

	public PatientDetail(int patientDetailID, int patientID, int employeeID, String symptom, Date checkDate) {
		PatientDetailID = patientDetailID;
		PatientID = patientID;
		EmployeeID = employeeID;
		Symptom = symptom;
		CheckDate = checkDate;
	}
	



	public int getPatientDetailID() {
		return PatientDetailID;
	}




	public void setPatientDetailID(int patientDetailID) {
		PatientDetailID = patientDetailID;
	}




	public int getPatientID() {
		return PatientID;
	}




	public void setPatientID(int patientID) {
		PatientID = patientID;
	}




	public int getEmployeeID() {
		return EmployeeID;
	}




	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}




	public String getSymptom() {
		return Symptom;
	}




	public void setSymptom(String symptom) {
		Symptom = symptom;
	}




	public Date getCheckDate() {
		return CheckDate;
	}




	public void setCheckDate(Date checkDate) {
		CheckDate = checkDate;
	}




	public PatientDetail() {
		// TODO Auto-generated constructor stub
	}
	
	

	//load object
	public Vector<Patient> GetAllPatientDetail(){
		String query = String.format("SELECT * FROM %s", this.table);
		
		//menampung hasil dari select
		ResultSet rs = con.executeQuery(query);
		
		//return data dari db 
		Vector<Patient> listPatientDetail = new Vector<>();
		
		//looping masukkin data ke vector
		try {
			while(rs.next()) {
				int patientDetailID = rs.getInt("PatientDetailID");
				int patientID = rs.getInt("PatientID");
				int employeeID = rs.getInt("EmployeeID");
				String symptom = rs.getString("Symptom");
				Date checkDate = rs.getDate("DOB");
				
				
				listPatientDetail.add(new PatientDetail(patientDetailID, patientID, employeeID, symptom, checkDate));			
			}
		return listPatientDetail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//insert object	
	public boolean insertPatientDetail() {
		String query = String.format("INSERT INTO %s Values (NULL,?,?,?,?)", this.table);
		
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(3, Symptom);
			ps.setDate(4, CheckDate);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

}
