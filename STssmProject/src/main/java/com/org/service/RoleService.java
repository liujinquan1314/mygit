package com.org.service;

import java.util.List;

import com.org.bean.Role;

public interface RoleService {
	
	public void add(Role role);
	
	public Role findById(int id);
	
	public List<Role> list(Role role);
	
	public void update(Role role);
	
	public void delete(Integer[] roleId);
	
	public List<Role>  findByName(Role role);

	public void update2(Role role);
	
	public Role findant(Role role);

}
