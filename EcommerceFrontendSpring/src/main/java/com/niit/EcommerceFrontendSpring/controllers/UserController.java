package com.niit.EcommerceFrontendSpring.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.model.Product;

@Controller
public class UserController 
{
	@Autowired 
	ProductDao productDao;
	
	@RequestMapping(value="/userhome")
	public String showUserHome(Model m,HttpSession session)
	{
		m.addAttribute("pageinfo", "Product Catalog");
		List<Product> listProducts=productDao.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "Products";
	}
	

}

