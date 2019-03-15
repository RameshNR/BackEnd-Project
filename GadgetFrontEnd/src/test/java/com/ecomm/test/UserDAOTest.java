package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;

public class UserDAOTest 
{

	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("priya");
		user.setPassword("pass123");
		user.setCustomername("priyavardhan");
		user.setEnable(true);;
		user.setRole("ROLE_USER");
		user.setAddress("chennai");
		
		assertTrue("problem in adding user",userDAO.registerUser(user));
	}
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail user=new UserDetail();
		user.setPassword("pass321");
		
		assertTrue("problem in updating user",userDAO.updateUser(user));
	}
	
}
