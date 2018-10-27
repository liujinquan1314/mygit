package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Role;
import com.org.dao.RoleDao;
import com.org.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao dao;
	
	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		try {
			dao.add(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Role> list(Role role) {
		// TODO Auto-generated method stub
		return dao.list(role);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		 try {
			dao.update(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer[] roleId) {
		// TODO Auto-generated method stub
		for(Integer id:roleId) {
			Role info=new Role();
			
			info.setRoleId(id);
			
			info.setRoleMark("1");
			try {
				dao.update(info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Role>  findByName(Role role ) {
		// TODO Auto-generated method stub
		return dao.findByName(role);
	}

	@Override
	public void update2(Role role) {
		// TODO Auto-generated method stub
		try {
			dao.update2(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	@Override
	public Role findant(Role role) {
		// TODO Auto-generated method stub
		return dao.findant(role);
	}

	

}