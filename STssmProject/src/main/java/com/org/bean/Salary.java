package com.org.bean;

import java.util.Date;

public class Salary {
	
	private int paymentId;
	
	private int userId;
	
	private Date paymentTime;
	
	private double paymentMoney;
	
	private String userName;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public double getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Salary [paymentId=" + paymentId + ", userId=" + userId + ", paymentTime=" + paymentTime
				+ ", paymentMoney=" + paymentMoney + ", userName=" + userName + "]";
	}
	

}
