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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.dao.UserDao;
import com.niit.EcommerceBackendSpring.model.Product;
import com.niit.EcommerceBackendSpring.model.User;

@Controller
public class UserController 
{
	@Autowired 
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/userhome")
	public String showUserHome(Model m,HttpSession session)
	{
		m.addAttribute("pageinfo", "Product Catalog");
		List<Product> listProducts=productDao.listProducts();
		m.addAttribute("productList", listProducts);
		
		return "Products";
	}
	
	@RequestMapping("/saveUsr")
	public ModelAndView saveUser(@ModelAttribute("usr") User user, final RedirectAttributes redirects) {
		ModelAndView mv = new ModelAndView("UserAdmin");
		System.out.println("adding product" + user.getUsername());
		boolean res = userDao.registerUser(user);
		return mv;

	}
	@RequestMapping("/register")
	public ModelAndView signUpUser(@ModelAttribute("usr") User user) {

		ModelAndView mv = new ModelAndView("UserAdmin");

		mv.addObject("usr", new User());
		return mv;
	}

}

