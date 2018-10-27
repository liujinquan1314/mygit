package com.org.dao;

import java.util.List;
import java.util.Map;

import com.org.bean.Ant;

public interface AntDao {
	
public List<Ant> list(Ant info);
	
public void add(Ant info);
	
public void delete(Integer roleId);
	
public List<Map> getMenuList(Integer roleId);

}
