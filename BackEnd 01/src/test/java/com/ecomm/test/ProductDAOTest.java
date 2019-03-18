package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

public class ProductDAOTest {
	
	static ProductDAO productDAO;
	
	@BeforeClass
	//if BeforeClasss Annotation error can't fix, click the test and select "Add Junit  4/5 Build path
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	//@Ignore
	@Test
	//if BeforeClasss Annotation error can't fix, click the test and select "Add Junit  4/5 Build path
	public void addProductTest()
	{
		Product product = new Product();
		product.setProductName("SONY Bravia");
		product.setProductDesc("4K UHD with 5G Network");
		product.setStock(5);
		product.setPrice(12000);
		product.setCategoryId(01);
		product.setSupplierId(10);
		System.out.println("Data will be Stored in The DataBase");
		assertTrue("Problem in Adding Product", productDAO.addProduct(product));
	
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product = productDAO.getProduct(14);
		
		assertTrue("Problem in Deleting Product", productDAO.deleteProduct(product));
		
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product = productDAO.getProduct(15);
		product.setPrice(90);
		product.setStock(90);
		assertTrue("Problem in Updating the Product", productDAO.updateProduct(product));
		
	}
	
	
	
	
	

	@Test
	public void listCategoryTest()
	{
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("problem in retriving the product",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println("Output 1");
			System.out.println(product.getProductId()+"    ");
			System.out.println(product.getProductName()+"    ");
			System.out.println(product.getStock()+"    ");
			System.out.println(product.getPrice()+"    ");
			System.out.println("Output 1");
		}
	}
	

	@Test
	public void listProductsByCategoriesTest()
	{
		List <Product> listProducts = productDAO.listProducts();
		assertTrue("Problem in Retrieve the Product", listProducts.size()>0);
		
		for (Product product:listProducts)
		{
			System.out.println("Output 2");
		System.out.print(product.getProductId()+"    ");
		System.out.print(product.getProductName()+"    ");
		System.out.print(product.getStock()+"    ");
		System.out.print(product.getPrice()+"    ");
		System.out.println("Output 2");		
		}
	}
	
	
	

}
