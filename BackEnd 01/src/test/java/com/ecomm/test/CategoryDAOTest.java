package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest {
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	//if BeforeClasss Annotation error can't fix, click the test and select "Add Junit  4/5 Build path
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	//@Ignore
	@Test       
	//if BeforeClasss Annotation error can't fix, click the test and select "Add Junit  4/5 Build path
	public void addCategoryTest()
	{
		Category category = new Category();
		category.setCategoryName("Sony Bravia");
		category.setCategoryDesc("8K UHD TV Android");
		
		assertTrue("Problem in Adding Category", categoryDAO.addCategory(category));
		
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category = categoryDAO.getCategory(2);
		
		assertTrue("Problem in Deleting Category", categoryDAO.deleteCategory(category));
		
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory(2);
	//	category.setCategoryName("Ramesh NR");
		category.setCategoryDesc("New Brand");
		assertTrue("Problem in Updating the Category", categoryDAO.updateCategory(category));
		
	}
	
	@Test
	public void retrieveCategories()
	{
		List <Category> listCategories = categoryDAO.ListCategories();
		assertTrue("Problem in Retrieve the Category", listCategories.size()>0);
		
		for (Category category:listCategories)
		{
		System.out.print(category.getCategoryId()+"    ");
		System.out.print(category.getCategoryName()+"    ");
		System.out.println(category.getCategoryDesc());
		
		}
	}


}
