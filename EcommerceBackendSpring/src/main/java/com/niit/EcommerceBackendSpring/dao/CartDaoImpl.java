package com.niit.EcommerceBackendSpring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcommerceBackendSpring.model.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDaoImpl() {
		
	}

	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean addCartItem(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean deleteCartItem(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}catch(Exception e) {
		return false;
		}
	}

	public boolean updateCartItem(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception e) {
		return false;
		}
	}

	public Cart getCartItem(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		return cart;
	}

	public List<Cart> listCartItems(String username) {
		return sessionFactory.getCurrentSession().createQuery("From Cart").list();
	}

}
