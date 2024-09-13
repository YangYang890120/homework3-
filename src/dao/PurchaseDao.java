package dao;

import java.util.List;

import model.Orders;
import model.Purchase;

public interface PurchaseDao {
	//新增
	void addPurchase(Purchase p);
	//查詢
	List<Purchase> selectPurchase();
	//用日期篩選
	List<Purchase> selectByDate(String date1,String date2);
	//查詢views
	List<Purchase> selectFromView();
	//出貨編號篩選
	List<Purchase> selectByPurchaseno(String purchasesno);
	//關鍵字查詢
	List<Purchase> selectByKeyWord(String keyword);
	List<Purchase> selectByKeyWord(String keyword,String date1,String date2);
	
	//新增
	void update(Purchase p);
	//刪除
	void delete(String purchaseno);
	
}
