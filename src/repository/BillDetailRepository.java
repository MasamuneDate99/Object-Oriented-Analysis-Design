package repository;

import java.util.List;

import model.BillDetail;

public class BillDetailRepository {
	
	public List<BillDetail> getAll(){
		return new BillDetail().GetAllBillDetail();
	}
	
	public boolean save(BillDetail payload) {
		BillDetail billDetail = new BillDetail();
		billDetail.setBill_ID(payload.getBill_ID());
		billDetail.setBillDetail_ID(payload.getBillDetail_ID());
		billDetail.setMedicineID(payload.getMedicineID());
		billDetail.setQuantity(payload.getQuantity());
		
		return billDetail.insertBill();
	}

}
