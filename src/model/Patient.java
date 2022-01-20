package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class Patient {
	private int PatientID;
	private String Name;
	private Date DOB;
	private String table = "patient";
	private Connect con = Connect.getConnection();

	// contructor kosong untuk buat object patient di class lain
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int patientID, String name, Date dOB) {
		PatientID = patientID;
		Name = name;
		DOB = dOB;
	}

	public int getPatientID() {
		return PatientID;
	}

	public void setPatientID(int patientID) {
		PatientID = patientID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	// load object
	public Vector<Patient> GetAllPatient() {
		String query = String.format("SELECT * FROM %s", this.table);

		// menampung hasil dari select
		ResultSet rs = con.executeQuery(query);

		// return data dari db
		Vector<Patient> listPatient = new Vector<>();

		// looping masukkin data ke vector
		try {
			while (rs.next()) {
				int patientID = rs.getInt("PatientID");
				String name = rs.getString("Name");
				Date dOB = rs.getDate("DOB");

				listPatient.add(new Patient(patientID, name, dOB));
			}
			return listPatient;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// insert object
	public boolean insertPatient() {
		String query = String.format("INSERT INTO %s Values (NULL,?,?)", this.table);

		PreparedStatement ps = con.prepareStatement(query);

		try {
			ps.setString(1, Name);
			ps.setDate(2, DOB);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// update object
	public boolean updateMedicine() {
		String query = String.format("UPDATE %s SET Name = ?, DOB = ? WHERE PatientID = ?", this.table);

		PreparedStatement ps = con.prepareStatement(query);

		try {
			ps.setString(1, Name);
			ps.setDate(2, DOB);
			ps.setInt(3, PatientID);

			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
