package model;

public class Bill {
	private int billId;
	private int employeeId;
	private int patientId;
	private String date;
	private String paymentType;
	private String status;
	private int billDetailId;
	private int medicineId;
	private int medicineQuantity;
	
	public Bill(int billId, int employeeId, int patientId, String date, String paymentType, String status,
			int billDetailId, int medicineId, int medicineQuantity) {
		super();
		this.billId = billId;
		this.employeeId = employeeId;
		this.patientId = patientId;
		this.date = date;
		this.paymentType = paymentType;
		this.status = status;
		this.billDetailId = billDetailId;
		this.medicineId = medicineId;
		this.medicineQuantity = medicineQuantity;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBillDetailId() {
		return billDetailId;
	}
	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public int getMedicineQuantity() {
		return medicineQuantity;
	}
	public void setMedicineQuantity(int medicineQuantity) {
		this.medicineQuantity = medicineQuantity;
	}
}