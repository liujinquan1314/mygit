package com.org.service;

import java.util.List;

import com.org.bean.Cost;
import com.org.bean.Role;

public interface CostService {
	
	public List<Cost> list(Cost cost);

	public void add(Cost role);
	
	public List<Cost> findByName(Cost cost); 
	
	public Cost findById(int id);
	
	public void update2(Cost cost);

	public void delete(Integer[] costId);

}
