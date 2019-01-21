package com.backend.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.SupplierDAO;
import com.backend.model.Supplier;

public class SupplierUnitTest {

    static SupplierDAO supplierDAO;
	
 @BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.backend");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
   @Test
   public void addSupplierTest()
   {
	   Supplier supplier=new Supplier();
	  supplier.setSupplierName("Evans");
	  supplier.setSupplierId(0);
	  supplier.setSupplierAddr("NORTHSOUTHEASTWEST");
	  
	  assertTrue("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
	   
   }
   @Test
   public void listSupplierTest()
   {
	   List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	   assertTrue("Problem in Listing Suppliers:",listSuppliers.size()>0);
	   for(Supplier supplier:listSuppliers)
	   {
		   System.out.println("Supplier ID:"+supplier.getSupplierId());
		   System.out.println("SupplierName:"+supplier.getSupplierName());
		   System.out.println("SupplierAddr:"+supplier.getSupplierAddr());
	   }
   }
}
