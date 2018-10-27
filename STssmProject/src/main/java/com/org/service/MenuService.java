package com.org.service;

import java.util.List;

import com.org.bean.Menu;
import com.org.bean.Role;

public interface MenuService {
	
	public List<Menu> list(Menu menu);
	
	public Menu getInfo(Menu menu);
	
	public void add(Menu info);

	public Menu findById(Integer menuId);

	public void update(Menu role);

	public void delete(Integer menu);
	
	public List<Menu> findzi(Menu menu);

}
