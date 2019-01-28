package com.niit.EcommerceBackendSpring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackendSpring.dao.SupplierDao;
import com.niit.EcommerceBackendSpring.model.Supplier;

public class SupplierTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDao supplierDao;

	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier = context.getBean(Supplier.class);
	}
	@Ignore
	@Test
	public void test() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("KLN");
		supplier.setSupplierAddr("bangalore");

		assertTrue("Problem in add Supplier:", supplierDao.addSupplier(supplier));

	}

	@Ignore
	@Test
	public void listSupplier() {
		Supplier supplier = new Supplier();
		List<Supplier> li = supplierDao.listSuppliers();
		System.out.println(li.size());
		for (Supplier s : li) {
			System.out.println(s.getSupplierAddr() + s.getSupplierId() + s.getSupplierName());
		}
	}

	// @Ignore
	// @Test
	// public void deleteSupplier() {
	// Supplier supplier = new Supplier();
	// assertTrue("Problem in deleting data:", supplierDao.deleteSupplier(2));
	// }
	@Ignore
	@Test
	public void updateSupplier() {
		Supplier supplier = supplierDao.getSupplierbySupplierName(1);
		supplier.setSupplierAddr("Hyderabad");
		supplierDao.updateSupplier(supplier);
		assertEquals("Problem in updating details", "Normal Supply", supplier.getSupplierName());
	}

	@Ignore
	@Test
	public void deleteSupplier() {
		Supplier supplier = supplierDao.getSupplierbySupplierName(3);
		supplierDao.deleteSupplier(supplier);
		assertEquals("Problem in deleting supplier", true, true);
	}

}
