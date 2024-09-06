package dao;

import java.util.List;

import model.Member;

public interface MemberDao {

	void addMember(Member m);
	
	List<Member> selectAll();
	List<Member> selectByAccount(String account);
	
	void update(Member m);
	
	void delete(Integer id);
}
