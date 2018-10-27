package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Salary;
import com.org.dao.SalaryDao;
import com.org.service.SalaryService;
@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDao dao;
	
	@Override
	public void add(Salary salary) {
		// TODO Auto-generated method stub
		dao.add(salary);
	}

	@Override
	public List<Salary> list(Salary salary) {
		// TODO Auto-generated method stub
		return dao.list(salary);
	}

	@Override
	public List<Salary> findByName(Salary salary) {
		// TODO Auto-generated method stub
		return dao.findByName(salary);
	}
	

}
