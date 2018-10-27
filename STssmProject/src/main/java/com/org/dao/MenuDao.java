package com.org.dao;

import java.util.List;

import com.org.bean.Menu;
import com.org.bean.Role;

public interface MenuDao {
	
	public List<Menu> list(Menu menu);
	
	public Menu getInfo(Menu menu);
	
	public void add(Menu info);
	
	public Menu findById( Integer id);
	
	public void update(Menu menu )throws Exception;
	
	public void delete(Integer menu)throws Exception;
	
	public List<Menu> findzi(Menu menu);

}
