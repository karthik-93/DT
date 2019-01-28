package com.niit.EcommerceBackendSpring;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackendSpring.dao.UserDao;
import com.niit.EcommerceBackendSpring.model.User;



public class UserTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDao userDao;

	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
		user = context.getBean(User.class);
	}
	@Ignore
	@Test
	public void insertUser() {
		user.setUsername("Mohan");
		user.setPassword("pass123");
		
		user.setCustomerAddr("Mumbai");
		boolean flag = userDao.registerUser(user);
		assertEquals("problem in inserting user", true, flag);
	}

	@Ignore
	@Test
	public void listMethod() {
		User user = new User();
		List<User> li = userDao.listUser();
		assertEquals("problem in getting list", 3, li.size());
		for (User p : li) {
			System.out.println(p.getUsername() + " " + p.getPassword());
		}

	}

	@Ignore
	@Test
	public void updateUser() {
		User user = userDao.getUserByUserName(1);
		user.setUsername("Mahesh");
		userDao.updateUser(user);
		//assertEquals("problem in updating user", 2500, product.getPrice());

	}

	@Ignore
	@Test
	public void deleteUser() {
		User user = userDao.getUserByUserName(4);
		userDao.deleteUser(user);
		System.out.println("Deleted successfully");

	}


}
