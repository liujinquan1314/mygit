package com.org.dao;

import java.util.List;

import com.org.bean.User;

public interface UserDao {
	
	public void add(User role )throws Exception;
	
	public void update(User role )throws Exception;
	public void update2(User role )throws Exception;
	
	public void delete(User role) throws Exception;
	
	public User findById( Integer id);
	
	public List<User> list(User user);
	
	public List<User> findByName(User user);
	
	public User login(User info);
	
	public User getUser(User info);

}
