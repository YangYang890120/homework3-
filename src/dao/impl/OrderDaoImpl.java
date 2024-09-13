package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrderDao;
import model.Orders;

public class OrderDaoImpl implements OrderDao{

	public static void main(String[] args) {
		//新增 已測試成功
		/*Orders o=new Orders("O011","12345678","E003","M005",50,"2024-09-05");
		new OrderDaoImpl().addOrder(o);*/
		/*List<Orders> l2=new OrderDaoImpl().selectByDate("2024-09-04","2024-09-09");
		for(Orders o:l2)
		{
			System.out.println(o.getId()
							+"\t"+o.getOrderno()
							+"\t"+o.getEmployeeno()
							+"\t"+o.getMemberno()
							+"\t"+o.getOrderamount()
							+"\t"+o.getDate());
		}*/
		/*List<Orders> l=new OrderDaoImpl().selectByOrderno("O005");
		Orders o=l.get(0);
		System.out.println(o.getId()
				+"\t"+o.getOrderno()
				+"\t"+o.getEmployeeno()
				+"\t"+o.getMemberno()
				+"\t"+o.getOrderamount()
				+"\t"+o.getDate());*/
		//查詢 已測試成功
		List<Orders> l=new OrderDaoImpl().selectFromView();
		for(Orders o:l)
		{
			System.out.println(
							"\t"+o.getOrderno()
							+"\t"+o.getEmployeeno()
							+"\t"+o.getMemberno()
							+"\t"+o.getOrderamount()
							+"\t"+o.getDate());
		}
		//修改 已測試成功
		/*List<Orders> l=new OrderDaoImpl().selectById(4);
		Orders[] o=l.toArray(new Orders[1]);
		
		if(o.length!=0)
		{
			o[0].setBarcode("23456789");
			
			o[0].setEmployeeno("E005");
			o[0].setMemberno("M008");
			o[0].setOrderamount(50);
			o[0].setDate("2024-08-05");	
			new OrderDaoImpl().update((o[0]));	
		//刪除
		}*/
		
		//new OrderDaoImpl().delete("O005");
	}

	@Override
	public void addOrder(Orders o) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into orders(orderno,barcode,employeeno,memberno,orderAmount,date)"
					+"values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, o.getOrderno());
			ps.setString(2, o.getBarcode());
			ps.setString(3, o.getEmployeeno());
			ps.setString(4, o.getMemberno());
			ps.setInt(5, o.getOrderamount());
			ps.setString(6, o.getDate());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Orders> selectOrder() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from orders";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("barcode"));
				o.setEmployeeno(rs.getString("employeeno"));
				o.setMemberno(rs.getString("memberno"));
				o.setOrderamount(rs.getInt("orderAmount"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}	
	@Override
	public List<Orders> selectById(Integer id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from orders where id=?";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("barcode"));
				o.setEmployeeno(rs.getString("employeeno"));
				o.setMemberno(rs.getString("memberno"));
				o.setOrderamount(rs.getInt("orderamount"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException x) {
			x.printStackTrace();
		}
		return l;
	}
	@Override
	public void update(Orders o) {
		Connection conn=DbConnection.getDb();
		String SQL="update orders set barcode=?,employeeno=?,memberno=?,orderamount=?,date=? where orderno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, o.getBarcode());
			ps.setString(2, o.getEmployeeno());
			ps.setString(3, o.getMemberno());
			ps.setInt(4, o.getOrderamount());
			ps.setString(5,o.getDate());
			ps.setString(6, o.getOrderno());
			ps.executeUpdate();
		} catch (SQLException x) {
			x.printStackTrace();
		}
	}
	@Override
	public void delete(String orderno) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from orders where orderno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, orderno);
			ps.executeUpdate();
		} catch (SQLException x) {
			x.printStackTrace();
		}
	}

	@Override
	public List<Orders> selectByOrderno(String Orderno) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from orders where orderno=?";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, Orderno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("barcode"));
				o.setEmployeeno(rs.getString("employeeno"));
				o.setMemberno(rs.getString("memberno"));
				o.setOrderamount(rs.getInt("orderamount"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException x) {
			x.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Orders> selectByDate(String date1, String date2) {
		Connection conn=DbConnection.getDb();
		String SQL="select *from ordersticket where date between ? and ?";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, date1);
			ps.setString(2, date2);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("productname"));
				o.setEmployeeno(rs.getString("name"));
				o.setMemberno(rs.getString("membername"));
				o.setOrderamount(rs.getInt("orderAmount"));
				o.setSum(rs.getInt("sum"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Orders> selectFromView() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from ordersticket";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				//o.setId(rs.getInt("id"));
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("productname"));
				o.setEmployeeno(rs.getString("name"));
				o.setMemberno(rs.getString("membername"));
				o.setOrderamount(rs.getInt("orderAmount"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Orders> selectByKeyWord(String keyword,String date1,String date2) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from ordersticket where concat(orderno,productname,name,membername,orderAmount,date) like ? and date between ? and ?";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, "%"+keyword+"%");
			ps.setString(2, date1);
			ps.setString(3, date2);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("productname"));
				o.setEmployeeno(rs.getString("name"));
				o.setMemberno(rs.getString("membername"));
				o.setOrderamount(rs.getInt("orderAmount"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Orders> selectByKeyWord(String keyword) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from ordersticket where concat(orderno,productname,name,membername,orderAmount,date) like ?";
		List<Orders> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, "%"+keyword+"%");

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Orders o=new Orders();
				o.setOrderno(rs.getString("orderno"));
				o.setBarcode(rs.getString("productname"));
				o.setEmployeeno(rs.getString("name"));
				o.setMemberno(rs.getString("membername"));
				o.setOrderamount(rs.getInt("orderAmount"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
}
