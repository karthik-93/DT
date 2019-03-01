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
	
	
	@Test
	public void addCart() {
	//cart.setCartId(001);
		cart.setPaymentStatus("Not paid");
		cart.setPrice(9000);
		cart.setProductId(2);
		cart.setQuantity(2);
		cart.setProductName("Shirts");
		cart.setUsername("Karthik");	
		
		assertEquals("adding cart failed",true,cartDao.addCartItem(cart));
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
		List<Cart> listCart = cartDao.listCartItems("username");
		assertTrue("Problem in displaying CartItems", listCart.size()>0);
		
		for(Cart cartItem:listCart)
		{
			System.out.println("CartItem Id:" + cartItem.getProductId()+" \t");
			System.out.println("ProductName:" + cartItem.getProductName()+" \t");
			System.out.println("ProductPrice:" + cartItem.getPrice()+" \t");
			System.out.println("Quantity:" + cartItem.getQuantity()+" \t");
			System.out.println("TotalPrice:" + cartItem.getPrice()*cartItem.getQuantity());
			System.out.println("------------------------------------");
		}
	}
	

}
