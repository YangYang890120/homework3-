package dao;




import java.util.List;

import model.Orders;

public interface OrderDao {
	void addOrder(Orders o);
	
	List<Orders> selectOrder();
	List<Orders> selectByEmployeename(String employeename);
	List<Orders> selectById(Integer id);
	
	void update(Orders o);
	
	void delete(Integer id);
	
	
	
}
