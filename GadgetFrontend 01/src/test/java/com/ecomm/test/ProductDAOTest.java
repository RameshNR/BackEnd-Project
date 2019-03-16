package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO; 

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product = new Product();
		product.setProductName("SONY MOBILE");
		product.setProductDesc("the Mobile support 5G network");
		product.setStock(20);
		product.setPrice(12000);
		product.setCategoryId(6);
		product.setSupplierId(6);
		
		assertTrue("Problem in Adding Product", productDAO.addProduct(product));
		
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product = productDAO.getProduct(6);
		
		assertTrue("Problem in Deleting Product", productDAO.deleteProduct(product));
		
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product = productDAO.getProduct(7);
		product.setPrice(11000);
		product.setStock(15);
		assertTrue("Problem in Updating the Product", productDAO.updateProduct(product));
		
	}
	
	@Test
	public void listCategoryTest()
	{
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("problem in retriving the product",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println(product.getProductId()+"    ");
			System.out.println(product.getProductName()+"    ");
			System.out.println(product.getStock()+"    ");
			System.out.println(product.getPrice()+"    ");
		}
	}
	
	@Test
	public void listProductsByCategoriesTest()
	{
		List <Product> listProducts = productDAO.listProducts();
		assertTrue("Problem in Retrieve the Product", listProducts.size()>0);
		
		for (Product product:listProducts)
		{
		System.out.print(product.getProductId()+"    ");
		System.out.print(product.getProductName()+"    ");
		System.out.print(product.getStock()+"    ");
		System.out.print(product.getPrice()+"    ");
				
		}
	}
	
}