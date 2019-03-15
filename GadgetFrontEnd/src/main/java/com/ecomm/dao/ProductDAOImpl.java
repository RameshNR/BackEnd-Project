package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Product;

@Repository("categoryDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@Override
	public boolean deleteProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Override
	public boolean updateProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Override
	public Product getProduct(int productId)
	{
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		session.close();
		return product;
	}
	@Override
	public List<Product> listProducts()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from product");
		List<Product>  listProducts= query.list();
		session.close();
		return listProducts;
	}
	@Override
	public List<Product>listProductByCategory(int categoryId)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from product where category");
		List<Product>  listProducts= query.list();
		session.close();
		return listProducts;
	}
}
