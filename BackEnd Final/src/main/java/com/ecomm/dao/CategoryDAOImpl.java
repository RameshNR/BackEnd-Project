package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired  // Object Automatically Created by this Annottaion
	SessionFactory sessionFactory;
	
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory)    ///Constructor
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Transactional
	public boolean addCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		}
		
		catch (Exception e) 
		{
			return false;
		}
	}
	
	@Transactional
	public boolean deleteCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	@Transactional
	public boolean updateCategory(Category category) {
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	
	@Transactional
	public Category getCategory(int categoryId) {
		Session session= sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, categoryId);
		session.close();
		return category;  
	}

	
	@Transactional
	public List<Category> ListCategories() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List <Category> listCategories = query.list();
		session.close();
		return listCategories;
	}
	
}
