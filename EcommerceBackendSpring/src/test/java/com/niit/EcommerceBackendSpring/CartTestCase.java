package com.niit.EcommerceBackendSpring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackendSpring.dao.CartDao;
import com.niit.EcommerceBackendSpring.model.Cart;


public class CartTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CartDao cartDao;

	@Autowired
	static Cart cart;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		cartDao = (CartDao) context.getBean("cartDao");
		cart = context.getBean(Cart.class);
	}
	
	@Ignore
	@Test
	public void addCart() {
		cart.setCartId(001);
		cart.setPaymentStatus("completed");
		cart.setPrice(2563);
		cart.setProductId(2);
		cart.setQuantity(2);
		cart.setProductName("Shirts");
		cart.setUsername("Karthik");	
		boolean res = cartDao.addCartItem(cart);
		assertTrue("adding cart failed", cartDao.addCartItem(cart));
	}
	
	@Ignore
	@Test
	public void updateCart() {
		Cart cart = cartDao.getCartItem(001);
		cart.setPrice(9000);
		cartDao.updateCartItem(cart);
		assertEquals("Problem in updating cart", cart.getCartId(),001);
	}
	
	@Ignore
	@Test
	public void deleteCart() {
		Cart cart = cartDao.getCartItem(1);
		cartDao.deleteCartItem(cart);
	}
	
	@Ignore
	@Test
	public void listCart() {
		Cart cart = new Cart();
		List<Cart> li = cartDao.listCartItems("Karthik");
		for(Cart c:li) {
			System.out.println(c.getPaymentStatus());
		}
	}
	

}
