package com.ecomm.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.model.Product;

public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		
		catch (Exception e)
		{
			return false;	
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		
		catch (Exception e)
		{
			return false;	
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try 
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		
		catch (Exception e)
		{
			return false;	
		}
	}

	@Override
	public Product getProduct(int productId) {
		Session session =sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
	}

	@Override
	public List<Product> listProducts()
	{
		Session session =sessionFactory.openSession();
		Query query = session.createQuery("from Product");    // import import org.hibernate.query.Query; to fix the error
		List <Product> listProducts = query.list(); 
		session.close();
		return listProducts;
	}

	@Override
	public List<Product> listProductByCategory(int categoryId) {
		Session session =sessionFactory.openSession();
		Query query = session.createQuery("from Product where Category");    // import import org.hibernate.query.Query; to fix the error
		
		List <Product> listProducts = query.list(); 
		session.close();
		return listProducts;
	}


}
