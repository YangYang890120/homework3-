package model;

public class Purchase {
	private Integer id;
	private String purchaseno;
	private String barcode;
	private String employeeno;
	private Integer purchaseAmount;
	private String date;
	private Integer sum;
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Purchase(String purchaseno, String barcode, String employeeno, Integer purchaseAmount, String date) {
		super();
		this.purchaseno = purchaseno;
		this.barcode = barcode;
		this.employeeno = employeeno;
		this.purchaseAmount = purchaseAmount;
		this.date = date;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPurchaseno() {
		return purchaseno;
	}
	public void setPurchaseno(String purchaseno) {
		this.purchaseno = purchaseno;
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
	public Integer getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Integer purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
