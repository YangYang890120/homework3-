package service;

import java.util.List;

import model.Member;

public interface MemberService {
	
	void add(Member m);
	
	List<Member> showMember();
	
	Member findByAccount(String account);
	
	List<Member> findBykeyWord(String keyword);
	
	void update(String account,String membername,String password,String phone ,String address,String membership);
	
	void delete(int id);
}
