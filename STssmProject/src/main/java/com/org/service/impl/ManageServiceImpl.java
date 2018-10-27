package com.org.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.AudHistory;
import com.org.bean.Cost;
import com.org.bean.Expense;
import com.org.dao.ManageDao;
import com.org.service.ManageService;
@Service
public class ManageServiceImpl implements ManageService {
	
	@Autowired
	private ManageDao dao;
	
	@Override
	public List<Expense> list(Expense expense) {
		// TODO Auto-generated method stub
		return dao.list(expense);
	}
	@Override
	public List<Expense> findByName(Expense expense) {
		// TODO Auto-generated method stub
		return dao.findByName(expense);
	}
	@Override
	public Expense findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Override
	public List<Cost> findcost(Integer id) {
		// TODO Auto-generated method stub
		return dao.findcost(id);
	}
	@Override
	public void addhis(AudHistory audHistory) {
		// TODO Auto-generated method stub
		
		
		dao.addhis(audHistory);
		
	}
	@Override
	public List<AudHistory> findadut(AudHistory audHistory) {
		// TODO Auto-generated method stub
		return dao.findadut(audHistory);
	}
	@Override
	public void updateExpense(Expense expense) {
		// TODO Auto-generated method stub
		dao.updateExpense(expense);
	}
	

}
