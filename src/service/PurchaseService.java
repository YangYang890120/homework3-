package service;

import java.util.List;

import model.Orders;
import model.Purchase;

public interface PurchaseService {
	void addPurchase(Purchase p);
	
	List<Purchase> selectPurchase();
	
	List<Purchase> selectByDate(String date1, String date2);
	
	List<Purchase> selectFromView();
	
	Purchase selectByPurchaseno(String purchaseno);
	
	//Purchase selectByid(Integer id);
	
	
	void update(String purchaseno,String barcode,String employeeno,Integer purchaseAmount,String date);
	
	void delete(String  Purchaseno);
	
}
