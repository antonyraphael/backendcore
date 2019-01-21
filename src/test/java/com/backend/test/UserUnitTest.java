package com.backend.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.backend.dao.UserDetailDAO;
import com.backend.model.UserDetail;

public class UserUnitTest {

static UserDetailDAO userdetailDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.backend");
		context.refresh();	
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("Antony");
		user.setPassword("howru");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Antony Raphael");
		user.setCustomerAddr("Kerala");
		assertTrue("Problem in adding UserDetail:",userdetailDAO.registerUser(user));
		
		}
	
	@Test
	   public void listUserDetailTest()
	   {
		   List<UserDetail> listUserDetails=userdetailDAO.listUserDetails();
		   assertTrue("Problem in Listing UserDetails:",listUserDetails.size()>0);
		  
		   for(UserDetail userdetail:listUserDetails)
		   {
			 System.out.println("UserName:"+userdetail.getUsername());
			 System.out.println("Password:"+userdetail.getPassword());
			 System.out.println("CustomerName:"+userdetail.getCustomerName());
		   }
	   }
	
}



