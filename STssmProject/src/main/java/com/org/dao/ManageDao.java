package com.org.dao;

import java.util.List;

import com.org.bean.AudHistory;
import com.org.bean.Cost;
import com.org.bean.Expense;

public interface ManageDao {
	
	public List<Expense> list(Expense expense);

	public List<Expense> findByName(Expense expense);
	
	//id²éµ¥¸ö
	public Expense findById(Integer id); 

	public List<Cost> findcost(Integer id);
	public void addhis(AudHistory audHistory );
	
	public List<AudHistory> findadut(AudHistory audHistory); 
	
	public void updateExpense(Expense expense);
	
}
