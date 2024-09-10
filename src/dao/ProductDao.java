package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	//新增商品 
	void add(Product p);
	//查詢全部商品
	List<Product> selectAll();
	//用商品編號篩選
	List<Product> selectByProductNo(String Productno);
	//用條碼選取商品修改
	List<Product>selectByBarcode(String barcode);
	//修改(用商品編號篩選
	void update(Product p);
	//修改 (在出貨頁面出貨時扣除庫存
	void updateAmount(Product p);
	//篩除(用商品編號篩選
	void delete(String productno);
}
