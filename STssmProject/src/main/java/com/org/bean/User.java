package com.org.bean;

public class User {
	
	private int userId;
	private int roleId;
	private String userName;
	private String userSex;
	private int userAge;
	private String userAccount;
	private String userPassword;
	private double userSalary;
	private String userMark;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public double getUserSalary() {
		return userSalary;
	}
	public void setUserSalary(double userSalary) {
		this.userSalary = userSalary;
	}
	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName + ", userSex=" + userSex
				+ ", userAge=" + userAge + ", userAccount=" + userAccount + ", userPassword=" + userPassword
				+ ", userSalary=" + userSalary + ", userMark=" + userMark + "]";
	}
	
	
	
	

}
