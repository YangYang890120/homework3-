package service;

import java.util.List;

import model.Orders;

public interface OrderService {
	void addOrder(Orders o);
	
	List<Orders> selectAll();
	
	List<Orders> selectByDate(String date1,String date2);//
	
	List<Orders> selectFromView();
	
	List<Orders> selectByKeyWord(String keyword);
	
	List<Orders> selectByKeyWord(String keyword,String date1,String date2);
	
	Orders selectByOrderno(String orderno);
	
	Orders selectByid(Integer id);
	
	
	void update(String orderno,String barcode,String employeeno,String memberno,Integer orderamount,String date);
	
	void delete(String  orderno);
}
