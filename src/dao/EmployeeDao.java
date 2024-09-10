package dao;

import java.util.List;

import model.Employee;


public interface EmployeeDao {
	//c
	void add(Employee e);
	//r
	//查詢全部
	List<Employee> selectAll();
	
	List<Employee> selectByAccount(String account);
	
	List<Employee> selectEmployee(String account,String password);
	
	List<Employee> selectById(Integer id);
	
	List<Employee> selectByKeyWord(String keyword);
	//u
	void update(Employee e);
	//d
	void delete(Integer id);
}
	