package model;

public class Member {
	private int id;
	private String memberno;
	private String membername;
	private String account;
	private String password;
	private String phone;
	private String address;
	private String membership;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String memberno, String membername, String account, String password, String phone,
			 String address, String membership) {
		super();
		this.memberno = memberno;
		this.membername = membername;
		this.account = account;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.membership = membership;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberno() {
		return memberno;
	}
	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	
}
