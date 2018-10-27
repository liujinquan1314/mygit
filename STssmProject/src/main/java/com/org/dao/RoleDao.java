package com.org.dao;

import java.util.List;

import com.org.bean.Role;

public interface RoleDao {
	
	public void add(Role role )throws Exception;
	
	public void update(Role role )throws Exception;
	public void update2(Role role )throws Exception;
	
	public void delete(Role role) throws Exception;
	
	public Role findById( Integer id);
	
	public List<Role> list(Role role);
	
	public List<Role> findByName(Role role);
	
	public Role findant(Role role);
	
}
 