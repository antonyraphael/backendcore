package com.backend.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.ProductDAO;

import com.backend.model.Product;

public class ProductUnitTest 
{
	static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.backend");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Lee Shirt");
		product.setProductDesc("Lee Brand T Shirts");
		product.setPrice(1600);
		product.setStock(45);
		product.setCategoryId(3);
		product.setSupplierId(1);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertTrue("Problem in Listing Products:",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println("Product ID:"+product.getProductId());
			System.out.println("Product Name:"+product.getProductName());
			System.out.println("Product Desc:"+product.getProductDesc());
			System.out.println("Product Price:"+product.getPrice());
			System.out.println("Product Desc:"+product.getStock());
		}
	}
}
