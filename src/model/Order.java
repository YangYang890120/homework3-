package model;

public class Order {
	private int id;
	private String orderno;
	private String productno;
	private String emlpoyee;
	private String memberno;
	private int amount;

	public Order(String orderno, String productno, String emlpoyee, String memberno, int amount) {
		super();
		this.orderno = orderno;
		this.productno = productno;
		this.emlpoyee = emlpoyee;
		this.memberno = memberno;
		this.amount = amount;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public String getMemberno() {
		return memberno;
	}
	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getEmlpoyee() {
		return emlpoyee;
	}
	public void setEmlpoyee(String emlpoyee) {
		this.emlpoyee = emlpoyee;
	}	
}
