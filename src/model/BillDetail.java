package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class BillDetail {
	private int BillDetail_ID, Bill_ID, MedicineID, Quantity;
	private String table = "bill_detail";
	private Connect con = Connect.getConnection();

	public BillDetail() {
		// TODO Auto-generated constructor stub
	}

	public BillDetail(int billDetail_ID, int bill_ID, int medicineID, int quantity) {
		BillDetail_ID = billDetail_ID;
		Bill_ID = bill_ID;
		MedicineID = medicineID;
		Quantity = quantity;
	}

	public int getBillDetail_ID() {
		return BillDetail_ID;
	}

	public void setBillDetail_ID(int billDetail_ID) {
		BillDetail_ID = billDetail_ID;
	}

	public int getBill_ID() {
		return Bill_ID;
	}

	public void setBill_ID(int bill_ID) {
		Bill_ID = bill_ID;
	}

	public int getMedicineID() {
		return MedicineID;
	}

	public void setMedicineID(int medicineID) {
		MedicineID = medicineID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	// load object
	public Vector<BillDetail> GetAllBillDetail() {
		String query = String.format("SELECT * FROM %s", this.table);

		// menampung hasil dari select
		ResultSet rs = con.executeQuery(query);

		// return data dari db
		Vector<BillDetail> listBillDetail = new Vector<>();

		// looping masukkin data ke vector
		try {
			while (rs.next()) {
				int billDetail_ID = rs.getInt("BillDetail_ID");
				int bill_ID = rs.getInt("Bill_ID");
				int medicineID = rs.getInt("MedicineID");
				int quantity = rs.getInt("Quantity");

				listBillDetail.add(new BillDetail(billDetail_ID, bill_ID, medicineID, quantity));
			}
			return listBillDetail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// insert object
	public boolean insertBill() {
		String query = String.format("INSERT INTO %s Values (NULL,?,?,?)", this.table);

		PreparedStatement ps = con.prepareStatement(query);

		try {
			ps.setInt(1, Bill_ID);
			ps.setInt(2, MedicineID);
			ps.setInt(3, Quantity);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
