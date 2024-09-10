package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.ProductDao;
import model.Employee;
import model.Product;

public class ProductDaoImpl implements ProductDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new ProductDaoImpl().add(new Product("測試","測試","測試",1000,10));
		
		/*List<Product> l=new ProductDaoImpl().selectAll();
		for(Product p:l)
		{
			System.out.println(p.getId()+
					"\t"+p.getProductno()+
					"\t"+p.getProductname()+
					"\t"+p.getPrice()+
					"\t"+p.getAmount()
				);
		}*/
		List<Product> l=new ProductDaoImpl().selectByBarcode("12345678");
		Product p=l.get(0);
		System.out.println(p.getBarcode()+"\t庫存數量"+p.getAmount());
		
	}

	@Override
	public void add(Product p) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into product(productno,productname,barcode,price,amount)"
				+"values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,p.getProductno());
			ps.setString(2,p.getProductname());
			ps.setString(3,p.getBarcode());
			ps.setInt(4,p.getPrice());
			ps.setInt(5,p.getAmount());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from product";		
		List<Product> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setBarcode(rs.getString("barcode"));
				p.setPrice(rs.getInt("price"));
				p.setAmount(rs.getInt("amount"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Product> selectByProductNo(String productno) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from product where productno=?";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, productno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p =new Product();
				p.setId(rs.getInt("id"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setBarcode(rs.getString("barcode"));
				p.setPrice(rs.getInt("price"));
				p.setAmount(rs.getInt("amount"));
			
				l.add(p);
			}		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Product> selectByBarcode(String barcode) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from product where barcode=?";
		List<Product> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, barcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p =new Product();
				p.setId(rs.getInt("id"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setBarcode(rs.getString("barcode"));
				p.setPrice(rs.getInt("price"));
				p.setAmount(rs.getInt("amount"));
			
				l.add(p);
			}		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l;
	}
	@Override
	public void update(Product p) {
		Connection conn=DbConnection.getDb();
		String SQL="update product set productno=?,productname=?,barcode=?,price=?,amount=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getProductno());
			ps.setString(2, p.getProductname());
			ps.setString(3, p.getBarcode());
			ps.setInt(4, p.getPrice());
			ps.setInt(5, p.getAmount());
			ps.setInt(6, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateAmount(Product p) {
		Connection conn=DbConnection.getDb();
		String SQL="update product set amount=? where barcode=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1,p.getAmount());
			ps.setString(2, p.getBarcode());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void delete(String productno) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="delete from product where productno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, productno);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
