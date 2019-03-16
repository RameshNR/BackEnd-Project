package com.ecomm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.model.Product;
import com.ecomm.model.UserDetails;

public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetails user) {
		try 
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		
		catch (Exception e)
		{
			return false;	
		}
	}

	@Override
	public boolean updateUser(UserDetails user) {
		try 
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		
		catch (Exception e)
		{
			return false;	
		}
	}

	@Override
	public UserDetails getUser(String username) {
		Session session = sessionFactory.openSession();
		UserDetails user = session.get(UserDetails.class, username);
		session.close();
		return user;
	}
	

}
