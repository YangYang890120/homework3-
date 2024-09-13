package service.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

	public static void main(String[] args) {
		Product p=new ProductServiceImpl().findByBarcode("12345678");
		System.out.println(p.getBarcode()+"\t存貨"+p.getAmount());
		Product p1=new ProductServiceImpl().findByProductno("P001");
		System.out.println(p1.getBarcode()+"\t存貨"+p1.getAmount());
		
	}
	ProductDaoImpl pdi=new ProductDaoImpl();
	@Override
	public void addProduct(Product p) {
		List<Product> l=pdi.selectByProductNo(p.getProductno());
		pdi.add(p);
	}

	@Override
	public List<Product> selcetP() {
		List<Product> l=pdi.selectAll();
		return l;
	}

	@Override
	public Product findByProductno(String productno) {
		List<Product> l=pdi.selectByProductNo(productno);
		Product[] p=l.toArray(new Product[0]);
		return p[0];
	}

	@Override
	public void update(String productno, String productname, String barcode, Integer price, Integer amount) {
		Product p=findByProductno(productno);
		
		p.setProductname(productname);
		p.setBarcode(barcode);
		p.setPrice(price);
		p.setAmount(amount);
		pdi.update(p);
	}
	@Override
	public Product findByBarcode(String barcode) {
		List<Product> l=pdi.selectByBarcode(barcode);
		Product[] p=l.toArray(new Product[0]);
		return p[0];
	}

	@Override
	public void updateByOrderamount(String Barcode,Integer amount) {
		Product p=findByBarcode(Barcode);
		p.setAmount(amount);
		pdi.updateAmount(p);
		
		
	}
	@Override
	public void delete(String productno) {
		pdi.delete(productno);
	}

	@Override
	public boolean findBarcode(String barcode) {
		List<Product> l=pdi.selectByBarcode(barcode);
		boolean x=false;
		if(l.size()!=0)
		{
			x=true;
		}
		return x;
	}




}
