package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/login")
	public String showLogin(Model m) {
		m.addAttribute("pageinfo","login");
		return "login";
	}
	@RequestMapping("/home")
	public String showHome(Model m) {
		m.addAttribute("pageinfo","home");
		return "home";
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
