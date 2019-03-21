package com.ecomm.test;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
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
		product.setProductName("SONY");
		product.setProductDesc("8K UHD Wide");
		product.setStock(10);
		product.setPrice(120000);
		product.setCategoryId(04);
		product.setSupplierId(2);
		
		System.out.println("\n");
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
		Product product = productDAO.getProduct(13);
		product.setPrice(0);
		product.setStock(0);
		assertTrue("Problem in Updating the Product", productDAO.updateProduct(product));
	}
	
	@Test
	public void retriveProductTest()
	{
	System.out.println("\n" +"\n");
	System.out.println("---------  Product Data Retrive from Table  ----------");
	
	List<Product> listProducts = productDAO.listProducts();
	assertTrue("Problem in Retriving the Product", listProducts.size()>0);
	
	for(Product product:listProducts)
	{
	System.out.println("Product Name: "+ product.getProductName());
	System.out.println("Product Discription: "+ product.getProductDesc());
	System.out.println("Product Price: "+ product.getPrice());
	System.out.println("Product Stock: "+ product.getStock());
	System.out.println("Product Supplier ID: "+ product.getSupplierId());
	}
	}
	
	
	@Test
	public void listCategoryTest()
	{
		System.out.println("\n" +"\n");
		System.out.println("---------  Product Data Retrive from Table With Category  ----------");
		
		List<Product> listProducts = productDAO.listProducts();
		assertTrue("problem in retriving the product",listProducts.size()>0); 
		
		for(Product product:listProducts)
		{
			System.out.println("\n**************************************");
			System.out.println("Product Name: "+ product.getProductName());
			System.out.println("Product Discription: "+ product.getProductDesc());
			System.out.println("Product Price: "+ product.getPrice());
			System.out.println("Product Stock: "+ product.getStock());
			System.out.println("Product Supplier ID: "+ product.getSupplierId());
			System.out.println("**************************************");
			}
	}


}
