package com.niit.EcommerceBackend.daoimpll;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.EcommerceBackend.dao.CategoryDao;
import com.niit.EcommerceBackend.model.Category;
import com.niit.EcommerceBackend.model.Product;

@Repository("categoryDao")
@Service
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//	@Override
//	public List<Category> listCategories() {
//		Session session = sessionFactory.openSession();
//		Query query = (Query) session.createQuery("from Category");
//		List list = ((org.hibernate.query.Query) query).list();
//		return list;
//
//	}
	
	@SuppressWarnings("unchecked")
	public List<Category> listCategories() {
		return sessionFactory.getCurrentSession().createQuery("From Category").list();
	}

	public List<Product> listProducts(Product product) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Category");
		List list = query.list();

		return list;
	}
	
	@Override
	public Category getCategorybyCategoryName(int categoryId) {
		Session session = sessionFactory.openSession();
		Category category = session.get(Category.class, categoryId);
		return category;
	}

}
