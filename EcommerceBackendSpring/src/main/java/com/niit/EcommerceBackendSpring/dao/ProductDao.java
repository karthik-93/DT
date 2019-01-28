package com.niit.EcommerceBackendSpring.dao;

import java.util.List;

import com.niit.EcommerceBackendSpring.model.Product;


public interface ProductDao {
	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public List<Product> listProducts();

	public Product getProductbyProductname(int productId);

	public boolean deleteProduct(Product product);

}
