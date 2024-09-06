package model;

public class Orders {
	private int id;
	private String orderno;
	private String barcode;
	private String employeeno;
	private String memberno;
	private int orderamount;
	private String date;


	public Orders(String orderno, String barcode, String employeeno, String memberno, int orderamount, String date) {
		super();
		this.orderno = orderno;
		this.barcode = barcode;
		this.employeeno = employeeno;
		this.memberno = memberno;
		this.orderamount = orderamount;
		this.date = date;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getEmployeeno() {
		return employeeno;
	}
	public void setEmployeeno(String employeeno) {
		this.employeeno = employeeno;
	}
	public int getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(int orderamount) {
		this.orderamount = orderamount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Orders() {
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

	public String getMemberno() {
		return memberno;
	}
	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}

}
