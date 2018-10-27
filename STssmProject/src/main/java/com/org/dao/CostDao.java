package com.org.dao;

import java.util.List;

import com.org.bean.Cost;
import com.org.bean.Role;

public interface CostDao {
	
	public List<Cost> list(Cost cost);
	
	public void add(Cost cost )throws Exception;
	
	public List<Cost> findByName(Cost cost); 
	
	public Cost findById( Integer id);
	
	public void update2(Cost cost )throws Exception;

}
