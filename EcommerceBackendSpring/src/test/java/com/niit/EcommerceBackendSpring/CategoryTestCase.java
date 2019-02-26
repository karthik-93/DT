package com.niit.EcommerceBackendSpring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackendSpring.dao.CategoryDao;
import com.niit.EcommerceBackendSpring.model.Category;



public class CategoryTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDao categoryDao;

	@Autowired
	static Category category;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		category = context.getBean(Category.class);
	}
	@Ignore
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("new Category");
		category.setCategoryDesc("Rounirt of all Variety");
		boolean res = categoryDao.addCategory(category);
		assertEquals("problem in inserting  the data", true, res);
	}
	@Ignore
	@Test
	public void updateCategory() {
		Category category = categoryDao.getCategorybyCategoryName(3);
		category.setCategoryName("Jeans");
		categoryDao.updateCategory(category);
		assertEquals("Problem in updating category",category.getCategoryId(),85);
		
		
	}
	@Ignore
	@Test
	public void deleteCategory() {
		Category category = categoryDao.getCategorybyCategoryName(1);
		categoryDao.deleteCategory(category);
		assertEquals("Problem in deleting category",4,categoryDao.listCategories().size());
		
	}
	@Ignore
	@Test
	public void showCategories() {
		Category category = new Category();
		List<Category> li = categoryDao.listCategories();
		assertEquals("problem in getting list ", true, true);
		for(Category c : li) {
			System.out.println(c.getCategoryDesc()+" "+c.getCategoryId()+" "+c.getCategoryName());
		}
	}


}
