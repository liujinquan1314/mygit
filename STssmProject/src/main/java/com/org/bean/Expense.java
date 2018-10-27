package com.org.bean;

import java.util.Date;


public class Expense {
	// �������
	private Integer expenseId;

	// ������
	private Integer userId;
	
	//����������
	private String userName;

	// ����ԭ��
	private String expenseName;

	// ��������
	private String expenseDesc;

	// ����״̬
	private String expenseState;

	// �����ܽ��
	private Double expenseTotal;

	// ����ʱ��
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