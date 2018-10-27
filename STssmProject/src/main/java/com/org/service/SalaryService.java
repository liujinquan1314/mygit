package com.org.service;

import java.util.List;

import com.org.bean.Salary;

public interface SalaryService {
	
	public void add(Salary salary );
	
	public List<Salary> list(Salary salary);
	
	public List<Salary> findByName(Salary salary);

}
