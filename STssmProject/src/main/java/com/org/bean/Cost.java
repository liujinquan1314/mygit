package com.org.bean;

public class Cost {
	
	private int costId;
	
	private String costName;
	
	private String costDesc;
	
	private String costMark;
	
	private double expenseDetailsAmount;

	public double getExpenseDetailsAmount() {
		return expenseDetailsAmount;
	}

	public void setExpenseDetailsAmount(double expenseDetailsAmount) {
		this.expenseDetailsAmount = expenseDetailsAmount;
	}

	public int getCostId() {
		return costId;
	}

	public void setCostId(int costId) {
		this.costId = costId;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public String getCostDesc() {
		return costDesc;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public String getCostMark() {
		return costMark;
	}

	public void setCostMark(String costMark) {
		this.costMark = costMark;
	}

	@Override
	public String toString() {
		return "Cost [costId=" + costId + ", costName=" + costName + ", costDesc=" + costDesc + ", costMark=" + costMark
				+ "]";
	}
	
	

}
