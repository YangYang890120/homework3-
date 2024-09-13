package service.impl;

import java.util.List;


import dao.impl.OrderDaoImpl;
import model.Orders;
import service.OrderService;

public class OrderServiceImpl implements OrderService{

	public static void main(String[] args) {
		//new OrderServiceImpl().addOrder(new Orders("O012","12345678","E008","M008",50,"2024-09-06"));
		
	}
	OrderDaoImpl odi=new OrderDaoImpl();
	@Override
	public void addOrder(Orders o) {
	
			odi.addOrder(o);	
	}

	@Override
	public List<Orders> selectAll() {
		List<Orders> l=odi.selectOrder();
		return l;
	}

	@Override
	public Orders selectByid(Integer id) {
		List<Orders> l=odi.selectById(id);
		Orders[] o=l.toArray(new Orders[1]);
		return o[0];
	}

	@Override
	public void update(String orderno,String barcode, String employeeno, String memberno, Integer orderamount, String date) {
		Orders o=selectByOrderno(orderno);
		
		o.getOrderamount();
		o.setBarcode(barcode);
		o.setEmployeeno(employeeno);
		o.setMemberno(memberno);
		o.setOrderamount(orderamount);
		o.setDate(date);
		odi.update(o);
		
	}

	@Override
	public void delete(String Orderno) {
		odi.delete(Orderno);
		
	}

	@Override
	public Orders selectByOrderno(String orderno) {
		List<Orders> l=odi.selectByOrderno(orderno);
		Orders[] o=l.toArray(new Orders[1]);
		return o[0];
	}

	@Override
	public List<Orders> selectByDate(String date1, String date2) {
		List<Orders> l=odi.selectByDate(date1,date2);
		
		return l;
	}

	@Override
	public List<Orders> selectFromView() {
		List<Orders> l=odi.selectFromView();
		return l;
	}

	@Override
	public List<Orders> selectByKeyWord(String keyword) {
		List<Orders> l=odi.selectByKeyWord(keyword);
		return l;
	}

	@Override
	public List<Orders> selectByKeyWord(String keyword, String date1, String date2) {
	 	List<Orders> l=odi.selectByKeyWord(keyword, date1, date2);
		return l;
	}

}
