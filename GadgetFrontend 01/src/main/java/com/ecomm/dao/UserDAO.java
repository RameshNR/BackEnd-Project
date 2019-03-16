package com.ecomm.dao;

import com.ecomm.model.UserDetails;

public interface UserDAO 
{
	public boolean registerUser(UserDetails user);
	public boolean updateUser(UserDetails user);
	public UserDetails getUser(String username);

}

