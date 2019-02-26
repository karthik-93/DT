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
		@RequestMapping("/login")
		public String showLogin(Model m)
		{
		    m.addAttribute("pageinfo" , "Login");
			return "login";
		}
		@RequestMapping(value="/login_success") 
		public String loginCheck(Model m, HttpSession session)
		{
			String page="";
			boolean loggedIn=false;
			
			SecurityContext securitycontext=SecurityContextHolder.getContext();
			Authentication authentication=securitycontext.getAuthentication();
			
			
			String username=authentication.getName();
			
			Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
			
			for(GrantedAuthority role:roles)
			{
				session.setAttribute("role", role.getAuthority());;
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="Admintask";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				m.addAttribute("pageinfo" , "User Home");
				List<Product> listProducts = productDao.listProducts();
				m.addAttribute("pList", listProducts);
				loggedIn=true;
				page="UserPage";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username",username);
			}
			}
			
			
			return page;
		}
	

	 
}