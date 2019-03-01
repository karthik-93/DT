package com.niit.EcommerceBackendSpring.dao;

import com.niit.EcommerceBackendSpring.model.Orders;

public interface OrderDao {
	public boolean saveOrder(Orders orders);
	public boolean updateCart(String username);

}
