package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import connect.Connect;

import model.Medicine;

public class MedicineController {
	private int MedicineID, MPrice, MStock;
	private String MName;
	private String table = "medicine";
	
	private Connect con = Connect.getConnection();
	
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
