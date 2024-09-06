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
	public void update(Integer id,String barcode, String employeeno, String memberno, Integer orderamount, String date) {
		Orders o=selectByid(id);
		
		o.setBarcode(barcode);
		o.setEmployeeno(employeeno);
		o.setMemberno(memberno);
		o.setOrderamount(orderamount);
		o.setDate(date);
		odi.update(o);
		
	}

	@Override
	public void delete(Integer id) {
		odi.delete(id);
		
	}

}
