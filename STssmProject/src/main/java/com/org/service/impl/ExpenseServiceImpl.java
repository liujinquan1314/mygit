package com.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Expense;
import com.org.bean.ExpenseDetails;
import com.org.dao.ExpenseDao;
import com.org.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseDao dao;
	@Override
	public void add(Expense ea, Integer[] costId, Double[] expenseDetailsSmoumt) {
		// TODO Auto-generated method stub
		
		dao.addExpense(ea);
		
		for(int i=0;i<costId.length;i++) {
			
			ExpenseDetails ed=new ExpenseDetails();
			
			ed.setExpenseId(ea.getExpenseId());
			
			ed.setCostId(costId[i]);
			
			ed.setExpenseDetailsAmount(expenseDetailsSmoumt[i]);
			
			dao.addExpenseDetails(ed);
		}
	}

}
