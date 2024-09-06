package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.EmployeeDao;

import model.Employee;


public class EmployeeDaoImpl  implements EmployeeDao{

	public static void main(String[] args) {
		//新增
		//new EmployeeDaoImpl().add(new Employee("m002","吳宗憲","jack","456","台北","001","manager"));
		//查詢
		/*List<Employee> l=new EmployeeDaoImpl().selectAll();
		for(Employee m:l)
		{
			System.out.println(m.getId()+"\t"+m.getEmployeeno()+"\t"+m.getName()+"\t"+m.getAccount()+"\t"+m.getPassword()+
					m.getAddress()+"\t"+m.getPhone());
		}*/
		//修改
		List<Employee> l=new EmployeeDaoImpl().selectById(7);
		Employee[] e=l.toArray(new Employee[1]);
		if(e.length!=0)
		{
			e[0].setName("CO");
			e[0].setPassword("123");
			e[0].setAddress("台北");
			e[0].setPhone("123");
			e[0].setPosition("經理");
			
			new EmployeeDaoImpl().update(e[0]);			
		}
		//刪除
		//new EmployeeDaoImpl().delete(5);
	
	}
	
	
	@Override//新增
	public void add(Employee e) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into employee(employeeno,name,account,password,phone,address,position)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, e.getEmployeeno());
			ps.setString(2, e.getName());
			ps.setString(3, e.getAccount());
			ps.setString(4, e.getPassword());			
			ps.setString(5, e.getPhone());
			ps.setString(6, e.getAddress());
			ps.setString(7, e.getPosition());
			ps.executeUpdate();
		} catch (SQLException x) {			
			x.printStackTrace();
		}		
	}
	//讀取全部
	public List<Employee> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from employee";		
		List<Employee> l=new ArrayList();		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee e =new Employee();			
				e.setId(rs.getInt("id"));
				e.setEmployeeno(rs.getString("employeeno"));
				e.setName(rs.getString("name"));
				e.setAccount(rs.getString("account"));
				e.setPassword(rs.getString("password"));
				e.setAddress(rs.getString("address"));
				e.setPhone(rs.getString("phone"));
				e.setPosition(rs.getString("position"));				
				l.add(e);
			}			
		} catch (SQLException x) {			
			x.printStackTrace();
		}
		
		return l;
	}
	//讀取帳號
	public List<Employee> selectByAccount(String account) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from employee where account=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee e =new Employee();
				e.setId(rs.getInt("id"));
				e.setEmployeeno(rs.getString("employeeno"));
				e.setName(rs.getString("name"));
				e.setAccount(rs.getString("account"));
				e.setPassword(rs.getString("password"));
				e.setAddress(rs.getString("address"));
				e.setPhone(rs.getString("phone"));
				e.setPosition(rs.getString("position"));
				l.add(e);
			}			
		} catch (SQLException x) {
			x.printStackTrace();
		}	
		return l;
	}
	//修改
	public void update(Employee e) {
		Connection conn=DbConnection.getDb();
		String SQL="update employee set name=?,password=?,address=?,phone=?,position=? where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getPhone());
			ps.setString(5,e.getPosition());
			ps.setInt(6, e.getId());
			ps.executeUpdate();
		} catch (SQLException x) {
			x.printStackTrace();
		}
		
	}
	//讀取帳號密碼,用於登入核對
	public List<Employee> selectEmployee(String account, String password) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from employee where account=? and password=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, account);
			ps.setString(2, password);			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee e =new Employee();
				e.setId(rs.getInt("id"));
				e.setEmployeeno(rs.getString("employeeno"));
				e.setName(rs.getString("name"));
				e.setAccount(rs.getString("account"));
				e.setPassword(rs.getString("password"));
				e.setAddress(rs.getString("address"));
				e.setPhone(rs.getString("phone"));
				l.add(e);
			}			
		} catch (SQLException x) {
			x.printStackTrace();
		}	
		return l;
	}
	//用id讀取 
	public List<Employee> selectById(Integer id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from employee where id=?";
		List<Employee> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);		
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee m =new Employee();
				m.setId(rs.getInt("id"));
				m.setEmployeeno(rs.getString("employeeno"));
				m.setName(rs.getString("name"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
								
				l.add(m);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}
	//刪除 用id讀取資料並刪除
	public void delete(Integer id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from employee where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException x) {

			x.printStackTrace();
		}
		
	}
}
