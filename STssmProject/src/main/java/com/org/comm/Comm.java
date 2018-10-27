package com.org.comm;

public class Comm {
	

	//报销单的状态
	
	//作废
	public static final String EXPENSE_DEL="del";
	
	//初始状态
	public static final String EXPENSE_ZERO="0";
	
	//部门经理审核
	public static final String EXPENSE_ONE="1";
	
	//部门经理审核不通过
	public static final String EXPENSE_REONE="-1";
	
	//部门经理审核通过
	public static final String EXPENSE_SIX="6"; 
	
	//财务经理审核
	public static final String EXPENSE_TWO="2";
	
	//财务经理审核不通过
	public static final String EXPENSE_RETWO="-2";
	
	//财务经理审核通过
	public static final String EXPENSE_THREE="3";

}
