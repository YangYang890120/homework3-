package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		/*Member m =new Member("m006","jack","ddd","123","000","台北","鑽石");
		new MemberDaoImpl().addMember(m);*/
		
		/*List<Member> l=new MemberDaoImpl().selectAll();
		for(Member m:l)
		{
			System.out.println(m.getId()+
					"\t"+m.getMemberno()+
					"\t"+m.getMembername()+
					"\t"+m.getAccount()+
					"\t"+m.getPassword()+
					"\t"+m.getAddress()+
					"\t"+m.getPhone()+
					"\t"+m.getMembership());
		}*/
		/*List<Member> l=new MemberDaoImpl().selectByAccount("aaa");
		Member m=l.get(0);
		System.out.println(m.getId()+
				"\t"+m.getMemberno()+
				"\t"+m.getMembername()+
				"\t"+m.getAccount()+
				"\t"+m.getPassword()+
				"\t"+m.getAddress()+
				"\t"+m.getPhone()+
				"\t"+m.getMembership());*/
		/*List<Member> l=new MemberDaoImpl().selectByAccount("aaa");
		Member m=l.get(0);
		m.setMembername("Abc");
		m.setPassword("1234");
		m.setPhone("0011");
		m.setAddress("台中");
		m.setMembership("一般");
		new MemberDaoImpl().update(m);*/
		
		//new MemberDaoImpl().delete(4);
	}
	@Override
	public void addMember(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(memberno,membername,account,password,phone,address,membership)"
		+"values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getMemberno());
			ps.setString(2, m.getMembername());
			ps.setString(3, m.getAccount());
			ps.setString(4, m.getPassword());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getAddress());
			ps.setString(7, m.getMembership());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Member> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();		
			
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setMembership(rs.getString("membership"));				
				l.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByAccount(String account) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where account=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,account);
			ResultSet rs=ps.executeQuery();		
			
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setMembership(rs.getString("membership"));				
				l.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Member m) {
		Connection conn=DbConnection.getDb();
		String SQL="update member set membername=?,password=?,phone=?,address=?,membership=? where account=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getMembername());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getPhone());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMembership());
			ps.setString(6, m.getAccount());
			
			ps.executeUpdate();		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Integer id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete  from member where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Member> selectByKeyWord(String keyword) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where concat(id,memberno,membername,account,password,address,phone,membership)  like ?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,keyword);
			ResultSet rs=ps.executeQuery();		
			
			while(rs.next())
			{
				Member m=new Member();
				m.setId(rs.getInt("id"));
				m.setMemberno(rs.getString("memberno"));
				m.setMembername(rs.getString("membername"));
				m.setAccount(rs.getString("account"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setMembership(rs.getString("membership"));				
				l.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
		
	}

}
