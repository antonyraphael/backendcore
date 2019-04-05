package com.backend.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.CartDAO;

import com.backend.model.Cart;

public class CartUnitTest {

	@Autowired
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.vamshi");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(2);
		cart.setProductName("Lenova core");
		cart.setQuantity(1);
		cart.setPrice(4500);
		cart.setPaymentStatuse("NO");
		cart.setUsername("venky");
		
		assertTrue("Problem in Adding Cart" , cartDAO.addCart(cart));
	}
	
	@Ignore
	@Test
	public void displayCart()
	{
		List<Cart> listCart=cartDAO.listCart("vamshi");
		assertTrue("Problem in Display the Cart" , listCart.size()>0);
		for(Cart cart:listCart)
		{
			System.out.print(cart.getProductId()+"\t");
			System.out.print(cart.getProductName()+"\t");
			System.out.print(cart.getPrice()+"\t");
			System.out.print(cart.getPrice()*cart.getQuantity());
		}
		
	}


}
