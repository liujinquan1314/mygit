package com.org.dao;

import java.util.List;

import com.org.bean.Salary;

public interface SalaryDao {
	
	public void add(Salary salary );
	
	public List<Salary> list(Salary salary);
	
	public List<Salary> findByName(Salary salary);

}
