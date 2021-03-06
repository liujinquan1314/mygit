package com.org.bean;

import java.util.Date;


public class Expense {
	// 报销编号
	private Integer expenseId;

	// 报销人
	private Integer userId;
	
	//报销人姓名
	private String userName;

	// 报销原因
	private String expenseName;

	// 报销详情
	private String expenseDesc;

	// 报销状态
	private String expenseState;

	// 报销总金额
	private Double expenseTotal;

	// 报销时间
	private Date expenseTime;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getExpenseTime() {
		return expenseTime;
	}

	public void setExpenseTime(Date expenseTime) {
		this.expenseTime = expenseTime;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getExpenseDesc() {
		return expenseDesc;
	}

	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}

	public String getExpenseState() {
		return expenseState;
	}

	public void setExpenseState(String expenseState) {
		this.expenseState = expenseState;
	}

	public Double getExpenseTotal() {
		return expenseTotal;
	}

	public void setExpenseTotal(Double expenseTotal) {
		this.expenseTotal = expenseTotal;
	}

	@Override
	public String toString() {
		return "ExpenseAccount [expenseId=" + expenseId + ", userId=" + userId + ", expenseName=" + expenseName
				+ ", expenseDesc=" + expenseDesc + ", expenseState=" + expenseState + ", expenseTotal=" + expenseTotal
				+ ", expenseTime=" + expenseTime + "]";
	}

}