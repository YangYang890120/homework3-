package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.PurchaseDao;
import model.Orders;
import model.Purchase;

public class PurchaseDaoImpl implements PurchaseDao{

	public static void main(String[] args) {
		//good
		//new PurchaseDaoImpl().addPurchase(new Purchase("Pu011","12345678","測試",20,"2024-09-07"));
		//good
		/*List<Purchase> l2=new PurchaseDaoImpl().selectByDate("2024-09-04","2024-09-09");
			for(Purchase o:l2)
			{
				System.out.println(
								  o.getPurchaseno()
							+"\t"+o.getEmployeeno()
							+"\t"+o.getBarcode()
							+"\t"+o.getPurchaseAmount()
							+"\t"+o.getSum()
							+"\t"+o.getDate());
		}*/
		//good
		/*List<Purchase> l=new PurchaseDaoImpl().selectByPurchasesno("Pu005");
		Purchase o=l.get(0);
		System.out.println(
				"\t"+o.getPurchaseno()
				+"\t"+o.getEmployeeno()
				+"\t"+o.getBarcode()
				+"\t"+o.getPurchaseAmount()
				+"\t"+o.getDate());*/
		//good
		/*List<Purchase> l=new PurchaseDaoImpl().selectFromView();
		for(Purchase o:l)
		{
			System.out.println(
							"\t"+o.getPurchaseno()
							+"\t"+o.getEmployeeno()
							+"\t"+o.getBarcode()
							+"\t"+o.getPurchaseAmount()
							+"\t"+o.getSum()
							+"\t"+o.getDate());
		}*/
		//修改 已測試成功
		/*List<Purchase> l=new PurchaseDaoImpl().selectByPurchasesno("Pu004");
		Purchase[] o=l.toArray(new Purchase[0]);
		
		if(o.length!=0)
		{
			o[0].setBarcode("23456789");
			o[0].setEmployeeno("E005");
		
			o[0].setPurchaseAmount(50);
			o[0].setDate("2024-08-05");	
			new PurchaseDaoImpl().update((o[0]));
		}*/
		
		//new PurchaseDaoImpl().delete("Pu011");
		
	}

	@Override
	public void addPurchase(Purchase p) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into purchase(purchaseno,barcode,employeeno,purchaseAmount,date)"
				+ "values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getPurchaseno());
			ps.setString(2, p.getBarcode());
			ps.setString(3, p.getEmployeeno());
			ps.setInt(4, p.getPurchaseAmount());			
			ps.setString(5, p.getDate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Purchase> selectPurchase() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from purchase";
		List<Purchase> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Purchase p=new Purchase();
				p.setId(rs.getInt("id"));
				p.setPurchaseno(rs.getString("purchaseno"));
				p.setBarcode(rs.getString("barcode"));
				p.setEmployeeno(rs.getString("employeeno"));
				p.setPurchaseAmount(rs.getInt("purchaseAmount"));
				p.setDate(rs.getString("date"));
				l.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Purchase> selectByDate(String date1, String date2) {
		Connection conn=DbConnection.getDb();
		String SQL="select *from purchaseticket where date between ? and ?";
		List<Purchase> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, date1);
			ps.setString(2, date2);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Purchase p=new Purchase();
				p.setPurchaseno(rs.getString("purchaseno"));
				p.setBarcode(rs.getString("productname"));
				p.setEmployeeno(rs.getString("name"));
				p.setPurchaseAmount(rs.getInt("purchaseAmount"));
				p.setSum(rs.getInt("sum"));
				p.setDate(rs.getString("date"));
				l.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Purchase> selectFromView() {
		Connection conn=DbConnection.getDb();
		String SQL="select *from purchaseticket";
		List<Purchase> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Purchase p=new Purchase();
				p.setPurchaseno(rs.getString("purchaseno"));
				p.setBarcode(rs.getString("productname"));
				p.setEmployeeno(rs.getString("name"));
				p.setPurchaseAmount(rs.getInt("purchaseAmount"));
				p.setSum(rs.getInt("sum"));
				p.setDate(rs.getString("date"));
				l.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Purchase> selectByPurchaseno(String purchaseno) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from purchase where purchaseno=?";
		List<Purchase> l=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, purchaseno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Purchase p=new Purchase();
				p.setPurchaseno(rs.getString("purchaseno"));
				p.setBarcode(rs.getString("barcode"));
				p.setEmployeeno(rs.getString("employeeno"));
				p.setPurchaseAmount(rs.getInt("purchaseAmount"));
				p.setDate(rs.getString("date"));
				l.add(p);
			}
		} catch (SQLException x) {
			x.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Purchase p) {
		Connection conn=DbConnection.getDb();
		String SQL="update Purchase set barcode=?,employeeno=?,purchaseamount=?,date=? where purchaseno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getBarcode());
			ps.setString(2, p.getEmployeeno());
			ps.setInt(3, p.getPurchaseAmount());
			ps.setString(4,p.getDate());
			ps.setString(5, p.getPurchaseno());
			ps.executeUpdate();
		} catch (SQLException x) {
			x.printStackTrace();
		}
	}
	@Override
	public void delete(String purchaseno) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from purchase where purchaseno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, purchaseno);
			ps.executeUpdate();
		} catch (SQLException x) {
			x.printStackTrace();
		}
		
	}

}
