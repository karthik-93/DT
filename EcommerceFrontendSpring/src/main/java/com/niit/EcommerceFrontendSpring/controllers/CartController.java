package com.niit.EcommerceFrontendSpring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcommerceBackendSpring.dao.CartDao;
import com.niit.EcommerceBackendSpring.dao.OrderDao;
import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.dao.UserDao;
import com.niit.EcommerceBackendSpring.model.Cart;
import com.niit.EcommerceBackendSpring.model.Product;






@Controller
public class CartController {
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao	userDao;
	
	@Autowired
	OrderDao orderDao;
	
	
	@RequestMapping("/cart")
	public String showCart(Model m,HttpSession session)
	{
	String username=(String)session.getAttribute("username");
	List<Cart> cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));

	return "Cart";	
	}
	
	 @RequestMapping("addCart")
	 public String addToCart(@RequestParam(value="Id", required=true) int productId, HttpSession session,Model m)
	 {
	 	
	 	Product product=productDao.getProductbyProductname(productId);
	 	String username=(String)session.getAttribute("username");
	 	Cart cartItem=new Cart();
	 	cartItem.setProductId(product.getProductId());
	 	cartItem.setProductName(product.getProductName());
	 	cartItem.setQuantity(1);
	 	cartItem.setPrice(product.getPrice());
	 	cartItem.setPaymentStatus("NP");
	 	cartItem.setUsername(username);
	 	cartDao.addCartItem(cartItem);
	 	
	 	List<Cart> cartItemList=cartDao.listCartItems(username);
	 	m.addAttribute("cartItemList", cartItemList);
	 	m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));
	 	return "Cart";
	 	
	 	
	 }
	 @RequestMapping("/updateCartItem/{cartId}")
	 public String updateCartItem(@PathVariable("cartId")int  cartId, @RequestParam("quantity")int quantity, HttpSession session,Model m)
	 {
	 	 
	 	 Cart cart=cartDao.getCartItem(cartId);
	 	 cart.setQuantity(quantity);
	 	 cartDao.updateCartItem(cart);
	 	 String username=(String)session.getAttribute("username");
	 	 List<Cart> cartItemList=cartDao.listCartItems(username);
	 		m.addAttribute("cartItemList", cartItemList);
	 		m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));
	 	 return "Cart";
	 }
	 
	 @RequestMapping(value="/deleteCartItem/{cartId}")
		public String deleteCartItem(@PathVariable("cartId")int cartId,  HttpSession session,Model m)
		{
		 
			Cart cart = cartDao.getCartItem(cartId);
			cartDao.deleteCartItem(cart);
			String username=(String)session.getAttribute("username");	
			List<Cart> cartItemList=cartDao.listCartItems(username);
			m.addAttribute("cartItemList", cartItemList);
			m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));
			return "Cart";		
			
		}
	public int getGrandTotal(List<Cart> cartList)
	{
	int grandTotal=0,count=0;

	while(count<cartList.size())
	{
	grandTotal=grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice());	
	count++;

	}
		return grandTotal;
		
	}
	

}
