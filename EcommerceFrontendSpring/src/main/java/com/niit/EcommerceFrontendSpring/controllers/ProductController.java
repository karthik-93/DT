package com.niit.EcommerceFrontendSpring.controllers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.EcommerceBackendSpring.dao.CartDao;
import com.niit.EcommerceBackendSpring.dao.CategoryDao;
import com.niit.EcommerceBackendSpring.dao.ProductDao;
import com.niit.EcommerceBackendSpring.dao.SupplierDao;
import com.niit.EcommerceBackendSpring.model.Cart;
import com.niit.EcommerceBackendSpring.model.Category;
import com.niit.EcommerceBackendSpring.model.Product;
import com.niit.EcommerceBackendSpring.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	Product product;

	@Autowired
	ProductDao productDao;

	@Autowired
	Category category;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	Cart cart;
	
	@Autowired
	CartDao cartDao;

	@RequestMapping("/home")
	public ModelAndView displayIndex() {
		ModelAndView mv = new ModelAndView("index");
		List<Product> plist = productDao.listProducts();
		mv.addObject("pList", plist);
		System.out.println(plist.size());
		mv.addObject("msg", "Hello world");
		return mv;
	}

	@RequestMapping("productDetails")
	public ModelAndView getProDetails(@RequestParam(value = "Id", required = true) int productId) {
		product = productDao.getProductbyProductname(productId);
		ModelAndView mv = new ModelAndView("proDetails");
		mv.addObject("product", product);
		return mv;
	}

	

//	@RequestMapping("/home")
//	public String homeReturn() {
//		return "home";
//	}

//	@RequestMapping("/login")
//	public String loginReturn() {
//		return "login";
//	}

	@RequestMapping("/ddd")
	public ModelAndView addProducts(@ModelAttribute("prod") Product product) {

		ModelAndView mv = new ModelAndView("admin");

		mv.addObject("prod", new Product());
		return mv;
	}

	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("prod") Product product, final RedirectAttributes redirects) {
		ModelAndView mv = new ModelAndView("admin");
		System.out.println("adding product" + product.getProductName());
		boolean res = productDao.addProduct(product);
		return mv;

	}

	@RequestMapping("/adm")
	public String showPro() {
		return "Admintask";
	}

	@RequestMapping("AddPro")
	public ModelAndView addProcts(@ModelAttribute("product") Product product) {

		ModelAndView mv = new ModelAndView("productadding");

		mv.addObject("product", new Product());
		return mv;
	}

	@RequestMapping("/saveProd")
	public String addPro(@ModelAttribute("product") Product product, final RedirectAttributes redirects,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("productadding");
		System.out.println("adding product" + product.getProductName());
		boolean res = productDao.updateProduct(product);
		MultipartFile itemimage = product.getPimage();
		String rootdir = request.getSession().getServletContext().getRealPath("/");
		System.out.println("UUUUUUUUUUUUUUUUU " + rootdir);
		Path path = Paths.get(rootdir + "resources/includes/img/" + product.getProductId() + ".jpg");

		if (itemimage != null && !itemimage.isEmpty()) {
			try {
				System.out.println("OOOOOOOOOOOOOOOO " + path.toString());
				itemimage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("product image saving failed", e);
			}
		}

		return "redirect:/showallpro";

	}

	@RequestMapping("addctg")
	public ModelAndView addCat(@ModelAttribute("category") Category category) {
		ModelAndView mv = new ModelAndView("addctgg");
		mv.addObject("category", new Category());
		return mv;
	}

	@RequestMapping("/saveCat")
	public String addCattt(@ModelAttribute("category") Category category, final RedirectAttributes redirects) {
		ModelAndView mv = new ModelAndView("addctgg");
		System.out.println("adding category" + category.getCategoryName());
		boolean res = categoryDao.addCategory(category);
		return "redirect:/showallcat";
	}

	@RequestMapping("AddSupp")
	public ModelAndView addSupp(@ModelAttribute("supplier") Supplier supplier) {
		ModelAndView mv = new ModelAndView("addSupp");
		mv.addObject("supplier", new Supplier());
		return mv;
	}

	@RequestMapping("/savesupp")
	public String addsup(@ModelAttribute("supplier") Supplier supplier, final RedirectAttributes redirects) {
		ModelAndView mv = new ModelAndView("addSupp");
		System.out.println("adding supplier" + supplier.getSupplierName());
		boolean res = supplierDao.addSupplier(supplier);
		return "redirect:/showallsup";
	}

	@RequestMapping("/example2")
	public ModelAndView displayProduct() {
		ModelAndView mv = new ModelAndView("productTable");
		List<Product> plist = productDao.listProducts();
		mv.addObject("List", plist);
		System.out.println(plist.size());
		mv.addObject("msg", "Hello world");
		return mv;
	}

	@RequestMapping("productTab")
	public ModelAndView getTablePro(@RequestParam(value = "Id", required = true) int productId) {
		product = productDao.getProductbyProductname(productId);
		ModelAndView mv = new ModelAndView("productTable");
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping("catTab")
	public ModelAndView getTableCat(@RequestParam(value = "Id", required = true) int categoryId) {
		category = categoryDao.getCategorybyCategoryName(categoryId);
		ModelAndView mv = new ModelAndView("catTable");
		mv.addObject("category", category);
		return mv;
	}

	@RequestMapping("supTab")
	public ModelAndView getTableSup(@RequestParam(value = "Id", required = true) int supplierId) {
		supplier = supplierDao.getSupplierbySupplierName(supplierId);
		ModelAndView mv = new ModelAndView("supTable");
		mv.addObject("supplier", supplier);
		return mv;
	}

	@RequestMapping("/deletepro")
	public String deleteProduct(@RequestParam(value = "Id", required = true) int productId,
			final RedirectAttributes redirects) {
		ModelAndView mv = new ModelAndView("showAllProducts");
		Product product = productDao.getProductbyProductname(productId);
		productDao.deleteProduct(product);
		return "redirect:/showallpro";	}

	@RequestMapping("showallpro")
	public ModelAndView displayAllProList() {
		ModelAndView mv = new ModelAndView("showAllProducts");
		List<Product> plist = productDao.listProducts();
		mv.addObject("pList", plist);
		System.out.println(plist.size());
		mv.addObject("msg", "Hello world");
		return mv;
	}

	@RequestMapping("/editProd")
	public ModelAndView getEditProduct(@RequestParam(value = "Id", required = true) int productId,
			final RedirectAttributes redirectAttributes) {
		product = productDao.getProductbyProductname(productId);
		System.out.println("ddddddddddddddddd" + product.getProductName());
		ModelAndView mv = new ModelAndView("productadding");
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping("/editcat")
	public ModelAndView getEditCategory(@RequestParam(value = "Id", required = true) int categoryId,
			final RedirectAttributes redirectAttributes) {
		category = categoryDao.getCategorybyCategoryName(categoryId);
		System.out.println("ddddddddddddddddd" + category.getCategoryName());
		ModelAndView mv = new ModelAndView("addctgg");
		mv.addObject("category", category);
		return mv;
	}

	@RequestMapping("/deletecat")
	public ModelAndView deleteCat(@RequestParam(value = "Id", required = true) int categoryId,
			final RedirectAttributes redirects) {
		ModelAndView mv = new ModelAndView("showAllCategories");
		Category category = categoryDao.getCategorybyCategoryName(categoryId);
		categoryDao.deleteCategory(category);
		return mv;
	}

	@RequestMapping("showallsup")
	public ModelAndView displayAllSupList() {
		ModelAndView mv = new ModelAndView("showAllSuppliers");
		List<Supplier> slist = supplierDao.listSuppliers();
		mv.addObject("sList", slist);
		System.out.println(slist.size());
		mv.addObject("msg", "Hello world");
		return mv;
	}
	
	@RequestMapping("showallcat")
	public ModelAndView displayAllCatList() {
		ModelAndView mv = new ModelAndView("showAllCategories");
		List<Category> clist = categoryDao.listCategories();
		mv.addObject("cList", clist);
		System.out.println(clist.size());
		mv.addObject("msg", "Hello world");
		return mv;
	}
	
	@RequestMapping("backadmin")
		public String backAdmin(){
			return "Admintask";
		}
	
	

}


