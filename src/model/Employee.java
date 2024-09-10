package model;

import java.io.Serializable;

public class Employee implements Serializable{
	private int id;
	private String employeeno;
	private String name;
	private String account;
	private String password;
	private String address;
	private String phone;
	private String position;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeno, String name, String account, String password, String phone, String address,String position) {
		super();
		this.employeeno=employeeno;
		this.name = name;
		this.account = account;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.position=position;
	}
	public String getEmployeeno() {
		return employeeno;
	}
	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}	
}
