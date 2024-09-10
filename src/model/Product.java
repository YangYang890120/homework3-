package model;

public class Product {
	private Integer id;
	private String productno;
	private String barcode;
	private String productname;	
	private Integer price;
	private Integer amount;
	private Integer sum;
	public Product(String productno, String barcode, String productname, Integer price, Integer amount) {
		super();
		this.productno = productno;
		this.barcode = barcode;
		this.productname = productname;
		this.price = price;
		this.amount = amount;
		this.sum=price*amount;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		
		this.sum = price*amount;
	}
	
	
	
}
