package dao;




import java.util.List;

import model.Orders;

public interface OrderDao {
	//新增
	void addOrder(Orders o);
	//查詢全部訂單
	List<Orders> selectOrder();
	//用出貨編號篩選,
	List<Orders> selectByOrderno(String Orderno);
	//沒用到
	List<Orders> selectById(Integer id);
	//用日期篩選
	List<Orders> selectByDate(String date1,String date2);
	//查詢views
	List<Orders> selectFromView();
	//新增(會用出貨編號選擇
	void update(Orders o);
	//刪除 用出貨編號選擇
	void delete(String orderno);
	
	
	
}
