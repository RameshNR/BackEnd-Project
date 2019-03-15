package com.ecomm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test
	public void addcategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("redmi");
		category.setCategoryDesc("all smart mobile of redmi");
		
		assertTrue("problem is adding category",categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void deletecategoryTest()
	{
		Category category=new Category();
		assertTrue("problem is deleting the category",categoryDAO.deleteCategory(category));
	}
	
	@Ignore
	@Test
	public void updatecategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("all smart mobile and others gadget");
		
		assertTrue("problem is updating the  category",categoryDAO.updateCategory(category));
	}
}
