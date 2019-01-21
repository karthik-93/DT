package com.niit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.ProductDao;
import com.niit.EcommerceBackend.model.Product;

public class ProductUnittest {
	static ProductDao productDao;
	// private ProductDaoImpl productDaoImpl;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
	}

	
	@Test
	public void addProducttest() {
		Product product = new Product();
		// product.setProductName("Reebok Xl");
		// product.setProductId(00001);
		// product.setPrice(2500);
		// product.setStock(50);
		// product.setCategoryId(33);
		// product.setSupplierId(1);

		product.setProductName("puma");
		product.setProductId(3);
		product.setPrice(2500);
		product.setStock(500);
		product.setCategoryId(12);
		product.setSupplierId(2);
		// assertTrue("Problem in add product:",productDao.addProduct(product));

	}

	@Ignore
	@Test
	public void productlatest() {
		Product product = new Product();
		product.setProductId(000002);
		product.setProductDesc("Shoe Section");
		product.setPrice(2500);
		product.setStock(50);
		product.setProductName("Puma");
		product.setSupplierId(100);
		product.setSupplierId(929);
		boolean res = productDao.addProduct(product);
		assertEquals("Problem in inserting data", true, res);
	}
	@Ignore
	@Test
	public void deleteProduct() {
		Product product = productDao.getProductbyProductname(37);
		productDao.deleteProduct(product);
		System.out.println("Deleted successfully");
		
	}
	// @Ignore
	// @Test
	// public void getProduct() {
	// Product product = new Product();
	// boolean get = productDao.getProductId(000002);
	// assertEquals("Problem in getting Id",true,get);
	// }
	@Ignore
	@Test
	public void listMethod() {
		Product product = new Product();
		List<Product> li = productDao.listProducts();
		assertEquals("problem in getting list", 3, li.size());
		for (Product p : li) {
			System.out.println(p.getCategoryId() + " " + p.getPrice());
		}

	}
	@Ignore
	@Test
	public void updateProduct() {
		Product product = productDao.getProductbyProductname(38);
		product.setProductName("T-Shirt");
		productDao.updateProduct(product);
		assertEquals("problem in updating user",2500,product.getPrice());
		
	}

}
