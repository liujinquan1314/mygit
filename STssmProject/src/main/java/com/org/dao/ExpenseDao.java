package com.org.dao;

import com.org.bean.Expense;
import com.org.bean.ExpenseDetails;

public interface ExpenseDao {

	//��ӱ�����
	public int addExpense(Expense ea);
	
	//��ӱ�������ϸ
	public int addExpenseDetails(ExpenseDetails ed);
	
}
