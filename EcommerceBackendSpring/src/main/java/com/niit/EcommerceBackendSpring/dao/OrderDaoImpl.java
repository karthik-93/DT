package com.niit.EcommerceBackendSpring.dao;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcommerceBackendSpring.model.Orders;


@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDaoImpl() {
		
	}

	public OrderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public boolean saveOrder(Orders orders) {
		try {
			sessionFactory.getCurrentSession().save(orders);
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCart(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set paymentstatus='P' where username=:uname");
	query.setParameter("uname", username);
	int row_eff=query.executeUpdate();
	//session.close();
	if(row_eff>0)
		return true;
	else
		return false;
		
	}

}
