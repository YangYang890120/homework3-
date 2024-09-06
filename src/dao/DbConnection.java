package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		System.out.println(DbConnection.getDb());

	}
	public static Connection getDb()
	{
		Connection conn=null;
		String URL="jdbc:mysql://localhost:3306/company";
		String user="root";
		String password="1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(URL, user, password);
			
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;	
		
		
	}
	
	
	
}
