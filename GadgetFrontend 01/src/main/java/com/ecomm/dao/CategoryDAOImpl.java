package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Category;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO    // set as Umimplemented Methods 
{
	@Autowired  // Object Automatically Created by this Annottaion
	SessionFactory sessionFactroy;

	@Override
	public boolean addCategory(Category category) {
		try 
		{
			sessionFactroy.getCurrentSession().saveOrUpdate(category);
			return true;
		}
		
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try 
		{
			sessionFactroy.getCurrentSession().saveOrUpdate(category);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try 
		{
			sessionFactroy.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<Category> ListCategories() {
		Session session = sessionFactroy.openSession();
		Query query = session.createQuery("from Category");
		List <Category> listCategories = query.list();
		session.close();
		return listCategories;
	}

	@Override
	public Category getCategory(int categoryId) {
		Session session= sessionFactroy.openSession();
		Category category=(Category)session.get(Category.class, categoryId);
		session.close();
		return category;  
	}
	
	
}
