package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcommerceBackend.dao.ProductDao;
import com.niit.EcommerceBackend.model.Product;



@Controller
public class PageController {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("/login")
	public String showLogin(Model m) {
		m.addAttribute("pageinfo","login");
		return "login";
	}
	@RequestMapping("/home")
	/*
	public String showHome(Model m) {
		m.addAttribute("pageinfo","Home");
		return "home";
	}*/
	public ModelAndView defaultPage() {
	 	System.out.println("Trying to display the products data from backend");
	 	
		List<Product> plist=productDao.listProducts();
		ModelAndView model = new ModelAndView("home");
		model.addObject("pList", plist);
		System.out.println("products size is "+plist.size());
		System.out.println("products data from backend displayed successfully");
		return model;
		
	}
	@RequestMapping("/register")
	public String showRegister(Model m) {
		m.addAttribute("pageinfo", "register");
		return "register";
	}
	
	@RequestMapping("/aboutus")
	public String showAboutus(Model m) {
		m.addAttribute("pageinfo","aboutus");
		return "aboutus";
	}
	@RequestMapping("/contactus")
	public String showContactus(Model m) {
		m.addAttribute("pageinfo","contactus");
		return "contactus";
	}
}
