package com.niit.EcommerceBackendSpring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.model.Product;

public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDao productDao;

	@Autowired
	static Product product;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
		product = context.getBean(Product.class);
	}

	@Ignore
	@Test
	public void insertProduct() {
		
		product.setProductName("Slee");
		product.setProductDesc("Blue T-Shirt");
		product.setPrice(2580);
		boolean flag = productDao.addProduct(product);
		assertEquals("problem in inserting product", true, flag);
	}

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
		Product product = productDao.getProductbyProductname(4);
		product.setProductName("Pant");
		productDao.updateProduct(product);
		assertEquals("problem in updating user", 2500, product.getPrice());

	}
	@Ignore
	@Test
	public void deleteProduct() {
		Product product = productDao.getProductbyProductname(4);
		productDao.deleteProduct(product);
		System.out.println("Deleted successfully");

	}

}
