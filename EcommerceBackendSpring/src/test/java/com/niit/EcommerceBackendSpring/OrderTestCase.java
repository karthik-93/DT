package com.niit.EcommerceBackendSpring;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackendSpring.dao.CartDao;
import com.niit.EcommerceBackendSpring.dao.OrderDao;
import com.niit.EcommerceBackendSpring.model.Cart;
import com.niit.EcommerceBackendSpring.model.Orders;

public class OrderTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static OrderDao orderDao;

	@Autowired
	static Orders orders;
	
	
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		orderDao = (OrderDao) context.getBean("orderDao");
		System.out.println("in order testcase");
		orders = context.getBean(Orders.class);
	}
	
	@Test
	public void addOrder() {
		orders.setOrderDate(new java.util.Date());
		orders.setCartId(2);
		orders.setShippingAddress("Karnataka");
		orders.setTotalAmount(4500);
		orders.setTransType("COD");
		orders.setUsername("Karthik");
		assertTrue("problem in saving the order",orderDao.saveOrder(orders));
	}
}
