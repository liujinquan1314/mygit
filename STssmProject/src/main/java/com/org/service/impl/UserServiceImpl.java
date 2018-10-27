package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Role;
import com.org.bean.User;
import com.org.dao.UserDao;
import com.org.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public void add(User role) {
		// TODO Auto-generated method stub
		
		try {
			dao.add(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<User> list(User user) {
		// TODO Auto-generated method stub
		
		return dao.list(user);
	}

	@Override
	public void update(User role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer[] userId) {
		// TODO Auto-generated method stub
		for(Integer id:userId) {
			User info=new User();
			
			info.setUserId(id);
			
			info.setUserMark("1");
			try {
				dao.update(info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> findByName(User user) {
		// TODO Auto-generated method stub
		return dao.findByName(user);
		
	}

	@Override
	public void update2(User user) {
		// TODO Auto-generated method stub
		
		try {
			dao.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User login(User info) {
		// TODO Auto-generated method stub
		return dao.login(info);
	}

	@Override
	public User getUser(User info) {
		// TODO Auto-generated method stub
		return dao.getUser(info);
	}

}
