package dao;

import java.util.List;

import model.Employee;
import model.Member;

public interface MemberDao {

	void addMember(Member m);
	
	List<Member> selectAll();
	List<Member> selectByAccount(String account);
	
	List<Member> selectByKeyWord(String keyword);
	void update(Member m);
	
	void delete(Integer id);
}
