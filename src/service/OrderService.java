package service;

import java.util.List;

import model.Orders;

public interface OrderService {
	void addOrder(Orders o);
	
	List<Orders> selectAll();
	
	Orders selectByid(Integer id);
	
	void update(Integer id,String barcode,String employeeno,String memberno,Integer orderamount,String date);
	
	void delete(Integer id);
}
