package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import connect.Connect;

public class Medicine {
	private int MedicineID, MPrice, MStock;
	private String MName;
	private String table = "medicine";
	
	private Connect con = Connect.getConnection();
	//private Connect con = Connect.getConnection();
	
	public Medicine(int medicineID, int mPrice, int mStock, String mName) {
		MedicineID = medicineID;
		MPrice = mPrice;
		MStock = mStock;
		MName = mName;
	}
	
	public int getMedicineID() {
		return MedicineID;
	}
	public void setMedicineID(int medicineID) {
		MedicineID = medicineID;
	}
	public int getMPrice() {
		return MPrice;
	}
	public void setMPrice(int mPrice) {
		MPrice = mPrice;
	}
	public int getMStock() {
		return MStock;
	}
	public void setMStock(int mStock) {
		MStock = mStock;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	
	public Vector<Medicine> GetAllMedicine(){
		String query = String.format("SELECT * FROM %s", this.table);
		
		//menampung hasil dari select
		ResultSet rs = con.executeQuery(query);
		
		//return data dari db 
		Vector<Medicine> listMedicine = new Vector<>();
		
		//looping masukkin data ke vector
		try {
			while(rs.next()) {
				int medicineID = rs.getInt("MedicineID");
				String mName = rs.getString("MName");
				int mPrice = rs.getInt("MPrice");
				int mStock = rs.getInt("MStock");
				
				listMedicine.add(new Medicine(medicineID, mPrice, mStock, mName));			
			}
		return listMedicine;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//insert medicine	
	public boolean insertMedicine() {
		String query = String.format("INSERT INTO %s Values (NULL,?,?,?)", this.table);
		
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, MName);
			ps.setInt(2, MPrice);
			ps.setInt(3, MStock);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
