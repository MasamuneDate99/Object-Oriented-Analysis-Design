package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class Bill {
	private int Bill_ID, EmployeeID, PatientID;
	private Date DateTimeCreated;
	private String PaymentType, Status;
	private String table = "bill";
	private Connect con = Connect.getConnection();

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(int bill_ID, int employeeID, int patientID, Date dateTimeCreated, String paymentType, String status) {
		Bill_ID = bill_ID;
		EmployeeID = employeeID;
		PatientID = patientID;
		DateTimeCreated = dateTimeCreated;
		PaymentType = paymentType;
		Status = status;
	}

	public int getBill_ID() {
		return Bill_ID;
	}

	public void setBill_ID(int bill_ID) {
		Bill_ID = bill_ID;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public int getPatientID() {
		return PatientID;
	}

	public void setPatientID(int patientID) {
		PatientID = patientID;
	}

	public Date getDateTimeCreated() {
		return DateTimeCreated;
	}

	public void setDateTimeCreated(Date dateTimeCreated) {
		DateTimeCreated = dateTimeCreated;
	}

	public String getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	// load object
	public Vector<Bill> GetAllBill() {
		String query = String.format("SELECT * FROM %s", this.table);

		// menampung hasil dari select
		ResultSet rs = con.executeQuery(query);

		// return data dari db
		Vector<Bill> listBill = new Vector<>();

		// looping masukkin data ke vector
		try {
			while (rs.next()) {
				int bill_ID = rs.getInt("Bill_ID");
				int employeeID = rs.getInt("EmployeeID");
				int patientID = rs.getInt("PatientID");
				Date dateTimeCreated = rs.getDate("DateTimeCreated");
				String paymentType = rs.getString("PaymentType");
				String status = rs.getString("Status");

				listBill.add(new Bill(bill_ID, employeeID, patientID, dateTimeCreated, paymentType, status));
			}
			return listBill;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// insert object
	public boolean insertBill() {
		String query = String.format("INSERT INTO %s Values (NULL,?,?,?,?,?)", this.table);

		PreparedStatement ps = con.prepareStatement(query);

		try {
			ps.setInt(1, EmployeeID);
			ps.setInt(2, PatientID);
			ps.setDate(3, DateTimeCreated);
			ps.setString(4, PaymentType);
			ps.setString(5, Status);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// update object
	public boolean updateMedicine() {
		String query = String.format(
				"UPDATE %s SET EmployeeID = ?, PatientID = ?, DateTimeCreated = ?, PaymentType = ?, Status = ? WHERE Bill_ID = ?",
				this.table);

		PreparedStatement ps = con.prepareStatement(query);

		try {
			ps.setInt(1, EmployeeID);
			ps.setInt(2, PatientID);
			ps.setDate(3, DateTimeCreated);
			ps.setString(4, PaymentType);
			ps.setString(5, Status);
			ps.setInt(6, Bill_ID);

			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
