package service;

import java.util.List;

import model.Product;

public interface ProductService {
	
	void addProduct(Product p);
	
	List<Product> selcetP();
	
	Product findByProductno(String productno);
	
	Product findByBarcode(String barcode);
	
	boolean findBarcode(String barcode);
	
	void updateByOrderamount(String Barcode,Integer amount);
	
	void update(String productno,String productname,String barcode,Integer price , Integer amount);
	
	void delete(String productno);
	
}
