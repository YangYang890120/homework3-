package service.impl;

import java.util.List;

import dao.impl.PurchaseDaoImpl;
import model.Orders;
import model.Purchase;
import service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{

	public static void main(String[] args) {
		

	}
	PurchaseDaoImpl pdi=new PurchaseDaoImpl();
	@Override
	public void addPurchase(Purchase p) {
		pdi.addPurchase(p);
		
	}

	@Override
	public List<Purchase> selectPurchase() {
		List<Purchase> l=pdi.selectPurchase();
		return l;
	}

	@Override
	public List<Purchase> selectByDate(String date1, String date2) {
		
		List<Purchase> l=pdi.selectByDate(date1, date2);
		return l;
	}

	@Override
	public List<Purchase> selectFromView() {
		List<Purchase> l=pdi.selectFromView();
		return l;
	}

	@Override
	public Purchase selectByPurchaseno(String purchaseno) {
		List<Purchase> l=pdi.selectByPurchaseno(purchaseno);
		Purchase[] p=l.toArray(new Purchase[0]);
		return p[0];
	}

	@Override
	public void update(String purchaseno, String barcode, String employeeno, Integer purchaseAmount, String date) {
		Purchase o=selectByPurchaseno(purchaseno);
		
		o.setBarcode(barcode);
		o.setEmployeeno(employeeno);
		o.setPurchaseAmount(purchaseAmount);
		o.setDate(date);
		pdi.update(o);
	}

	@Override
	public void delete(String Purchaseno) {
		pdi.delete(Purchaseno);
		
	}

}
