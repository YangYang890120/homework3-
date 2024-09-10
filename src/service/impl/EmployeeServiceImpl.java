package service.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDaoImpl edi=new EmployeeDaoImpl();
	public void addEmployee(Employee e) {
		List<Employee> ln=edi.selectByAccount(e.getAccount());
		Employee[] en=ln.toArray(new Employee[0]);
		if(en.length!=0) {
			JOptionPane.showMessageDialog(null, "帳號已有人使用，請重新輸入");
		}
		else {
			JOptionPane.showMessageDialog(null, "新增員工成功");
			edi.add(e);	
		}}

	@Override
	public boolean findByAccount(String account) {
		List<Employee> l=edi.selectByAccount(account);
		boolean x=false;
		if(l.size()!=0)
		{
			x=true;
		}
		return x;
	}

	@Override
	public Employee login(String account, String password) {
		List<Employee>l=edi.selectEmployee(account, password);
		Employee m=null;
		if(l.size()!=0)
		{
			m=l.get(0);
		}
		return m;
	}

	@Override
	public List<Employee> AllEmployee() {
		List<Employee> l=edi.selectAll();	
		return l;
	}

	@Override
	public void delete(Integer id) {
		edi.delete(id);
		
	}

	@Override
	public void update(int id, String name, String password, String phone,String address ,String position) {
		Employee e=findById(id);
		
		e.setName(name);
		e.setPassword(password);
		e.setPhone(phone);
		e.setAddress(address);
		e.setPosition(position);
		edi.update(e);
		
	}

	@Override
	public Employee findById(int id) {
		List<Employee> l=edi.selectById(id);
		Employee[] e=l.toArray(new Employee[1]);
		return e[0];
		
	}

	@Override
	public List<Employee> findByKeyWord(String keyword) {
		List<Employee> l=edi.selectByKeyWord(keyword);
		return l;
	}

}
