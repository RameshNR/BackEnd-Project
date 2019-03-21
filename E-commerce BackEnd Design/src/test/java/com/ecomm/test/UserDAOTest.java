package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest {
	
	static UserDAO userDAO; 
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user = new UserDetail();
		user.setUsername("Ramesh NR");
		user.setPassword("NR");
		user.setCustomerName("Ramesh");
		user.setRole("WEB DEVELOPER");
		user.setEnable(true);
		user.setAddress("Chennai");
		
		assertTrue("Problem in Adding User", userDAO.registerUser(user));
		
		System.out.println("\n");
		System.out.println("*******    User \"" + user.getUsername() + "\" Details will be Stored in The DataBase     *******");
		System.out.println("\n");
	}
	
	
	//@Ignore
	@Test
	public void updateUserTest()
	{
		
		UserDetail user = userDAO.getUser("Ramesh NR");   // getUser means it will get Username from DataBase
		user.setPassword("RAM");
		
		assertTrue("Problem in updating user", userDAO.updateUser(user));
		
		System.out.println("\n");
		System.out.println("**********    User \"" + user.getUsername() + "\" Password Will be Changed    *********");
		System.out.println("\n");
		
	}
	

}
