package com.org.dao;

import com.org.bean.Expense;
import com.org.bean.ExpenseDetails;

public interface ExpenseDao {

	//添加报销单
	public int addExpense(Expense ea);
	
	//添加报销单明细
	public int addExpenseDetails(ExpenseDetails ed);
	
}
