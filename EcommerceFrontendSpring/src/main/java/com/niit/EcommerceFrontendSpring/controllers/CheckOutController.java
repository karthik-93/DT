package com.niit.EcommerceFrontendSpring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcommerceBackendSpring.dao.CartDao;
import com.niit.EcommerceBackendSpring.dao.OrderDao;
import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.dao.UserDao;
import com.niit.EcommerceBackendSpring.model.Cart;
import com.niit.EcommerceBackendSpring.model.Orders;
import com.niit.EcommerceBackendSpring.model.User;





@Controller
public class CheckOutController {
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderDao orderDao;
	
	@RequestMapping("/checkout")
public String checkout(Model m,HttpSession session)
{

		String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDao.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));

	User userDetail=userDao.getUserByUserName(username);
	System.out.println("getting user details");
		
String address=userDetail.getCustomerAddr();
		m.addAttribute("addr",address);
	return "Order";
}
	
	@RequestMapping(value="/updateAddress",method=RequestMethod.POST)
	public String updateAddress(@RequestParam("addr")String addr, Model m ,HttpSession session)
	{

		String username=(String)session.getAttribute("username");
		List<Cart> cartItemList=cartDao.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));
		User user=userDao.getUserByUserName(username);
	
user.setCustomerAddr(addr);
userDao.updateUser(user);
		
String address=user.getCustomerAddr();
		m.addAttribute("addr",address);
		
		
		
		return "Order";
		
		
	}
	@RequestMapping(value="/payment")
	public String PaymentPage(Model m,HttpSession session)
	{
		return "Payment";
		
		
	}
	
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("pmode")String pmode,Model m,HttpSession session)
	{
		
	
		
		String username=(String)session.getAttribute("username");
		Orders orders=new Orders();
		orders.setOrderDate(new java.util.Date());;
		orders.setShippingAddress(userDao.getUserByUserName(username).getCustomerAddr());
		orders.setTransType(pmode);
	orders.setUsername(username);
		
	List<Cart> cartItemList=cartDao.listCartItems(username);
	m.addAttribute("cartItemList", cartItemList);
	m.addAttribute("grandTotal",this.getGrandTotal(cartItemList));
	
User user=userDao.getUserByUserName(username);
	orders.setTotalAmount(this.getGrandTotal(cartItemList));
	orders.setCartId(cartItemList.get(0).getCartId());
	
	orderDao.saveOrder(orders);
	orderDao.updateCart(username);

	
	
m.addAttribute("order",orders);
	return "Receipt";
	
		
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
