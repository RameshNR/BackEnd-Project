package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOtest 
{
static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}

	@Test
	public void addproductTest()
	{
		Product product=new Product();
		
		product.setProductName("redmi note7");
		product.setProductDesc("the mbl with 4G and NFS");
		product.setStock(20);
		product.setPrice(15000);
		product.setCategoryId(3);
		product.setSuppilerId(3);
		
		assertTrue("problem in adding the product",productDAO.addProduct(product));
		
	}
	

	@Ignore
	@Test
	public void deleteproductTest()
	{
		Product product=productDAO.getProduct(3);
		assertTrue("problem in deleting", productDAO.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void updateproductTest()
	{
		Product product=new Product();
		product.setStock(20);
		product.setPrice(17000);
		
		assertTrue("problem in updating",productDAO.updateProduct(product));
		
	}
	
	@Test
	public void listCategoryTest()
	{
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("problem in retriving the product",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println(product.getProductName()+" ");
			System.out.println(product.getProductName()+" ");
			System.out.println(product.getStock()+" ");
			System.out.println(product.getPrice()+" ");
		}
	}

	@Test
	public void listProductByCategoryTest()
	{
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("problem in retriving the product",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println(product.getProductName()+" ");
			System.out.println(product.getProductName()+" ");
			System.out.println(product.getStock()+" ");
			System.out.println(product.getPrice()+" ");
		}
	}
}
