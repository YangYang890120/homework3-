package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee m);//新增員工
	
	boolean findByAccount(String account);//新增員工時的帳號重複驗證
	
	Employee login(String account ,String password);//員工登入驗證
	
	List<Employee> AllEmployee();//查詢員工
	
	Employee findById(int id);
	//修改
	void update(int id,String name,String password,String phone,String address,String position);
	
	void delete(Integer id);//刪除
	
	
	
}
