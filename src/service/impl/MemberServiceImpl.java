package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		

	}

	MemberDaoImpl mdi=new MemberDaoImpl();
	public void add(Member m) {
		mdi.addMember(m);
		
	}

	@Override
	public List<Member> showMember() {
		
		return mdi.selectAll();
	}

	@Override
	public void update(String account, String membername, String password, String phone, String address, String membership) {
		Member m=findByAccount(account);
		
		m.setMembername(membername);
		m.setPassword(password);
		m.setPhone(phone);
		m.setAddress(address);
		m.setMembership(membership);
		mdi.update(m);
		
	}
	public Member findByAccount(String account)
	{
		List<Member> l=mdi.selectByAccount(account);
		Member[] m=l.toArray(new Member[1]);
		return m[0];	
	}
	@Override
	public void delete(int id) {
		mdi.delete(id);
		
	}

}
