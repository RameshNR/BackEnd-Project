package com.ecomm.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.*;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user)
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Override
	public boolean updateUser(UserDetail user)
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@Override
	public UserDetail getUser(String username)
	{
		Session session=sessionFactory.openSession();
		UserDetail userDetail=session.get(UserDetail.class,username );
		return userDetail;
	}

}
