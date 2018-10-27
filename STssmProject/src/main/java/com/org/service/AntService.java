package com.org.service;

import java.util.List;
import java.util.Map;

import com.org.bean.Ant;

public interface AntService {
	public List<Ant> list(Ant info);
	
public void add(Integer roleId,Integer[] menuIds);
	
public List<Map> getMenuList(Integer roleId);

}
