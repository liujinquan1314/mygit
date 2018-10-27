package com.org.service;

import java.util.List;

import com.org.bean.User;

public interface UserService {
	
	public void add(User role);
	
	public User findById(int id);
	
	public List<User> list(User role);
	
	public void update(User role);
	
	public void delete(Integer[] userId);
	
	public List<User>  findByName(User user);

	public void update2(User role);	
	
	public User login(User info);
	
	public User getUser(User info);

}
