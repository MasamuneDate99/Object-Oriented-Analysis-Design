package model;

public class Medicine {
	private int MedicineID, MPrice, MStock;
	private String MName;
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
}
