package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
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

	@Transactional
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

	@Transactional
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

	@Transactional
	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		System.out.println(product.getProductName());
		session.close();
		return product;
	}

	@Transactional
	public List<Product> listProductByCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");    // import import org.hibernate.query.Query; to fix the error
		List <Product> listProducts = query.list(); 
		session.close();
		return listProducts;
	}

	@Transactional
	public List<Product> listProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where Category");    // import import org.hibernate.query.Query; to fix the error
		
		List <Product> listProducts = query.list(); 
		session.close();
		return listProducts;
	}

	
	
	
	

}
