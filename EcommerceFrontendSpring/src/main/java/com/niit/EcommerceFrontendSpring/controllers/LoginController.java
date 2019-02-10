package com.niit.EcommerceFrontendSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.model.Product;
import com.niit.EcommerceBackendSpring.model.User;

@Controller
public class LoginController {
	
	@Autowired
	User user;
	@Autowired
	ProductDao productDao;
	 //Spring Security related******************************************************************************
	 @RequestMapping("/auth")
		public String getAuthenticate()
		{
			return "auths";
		}
//	 @RequestMapping("/login")
//		public String getLog()
//		{
//			return "login";
//		}
	 @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
		public ModelAndView defaultPage() {
		 	System.out.println("Don1111111111111111111111");
		 	
			List<Product> plist=productDao.listProducts();
			ModelAndView model = new ModelAndView("index");
			model.addObject("pList", plist);
			System.out.println(plist.size());
			System.out.println("Don222222222222222222222222");
			return model;

		}
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout, final RedirectAttributes redirectAttributes) {
		 		System.out.println("login page");
			ModelAndView model = new ModelAndView("login");
//			String surl="";
//			if (error != null) {
//				model.addObject("error", "Invalid username and password!");
//				System.out.println("Error HERRRRRRRRRe");
////				model.setViewName("SingInPage");
//				return "login";
//			}
//
//			else if (logout != null) {
//				model.addObject("msg", "you have loggedout duccessfully");
//				System.out.println("LogOut");
////				model.setViewName("LandingPage");
//				return "redirect:hom1";
//				
//			}
//			else
//			{
//			System.out.println("some error");
//			model.setViewName("auths");
//			return "auths";
//			}
			
			return model;

		}
	 
	 

}
