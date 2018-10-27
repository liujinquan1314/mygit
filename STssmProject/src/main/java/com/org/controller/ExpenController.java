package com.org.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import com.org.bean.Cost;
import com.org.bean.Expense;
import com.org.bean.User;
import com.org.comm.Comm;
import com.org.service.CostService;
import com.org.service.ExpenseService;

@Controller
@RequestMapping("/expense/")
public class ExpenController {
	
	@Autowired
	private CostService costService;
	
	@Autowired
	private ExpenseService Expservice;
	
	//加载报销单
	@RequestMapping("loadadd.do")
	public String loadadd(Model model) {
		
		Cost cost=new Cost();
		
		cost.setCostMark("0");
		List<Cost> list=costService.list(cost);
		model.addAttribute("list",list);
		return "expense/expense_add";
		
	}
	
	//添加报销单,session获取值、报销单、明细、费用
	@RequestMapping("add.do")
	public String add(HttpSession session,Expense ea,Integer[] costId,Double[] expenseDetailsSmount,Model model) {
		
		//取得当前的用户信息
	
		User user=(User) session.getAttribute("user");
		
		if(user!=null) {
			
			ea.setUserId(user.getUserId());
			
			System.out.println(ea);
			
			//经理审核
			ea.setExpenseState(Comm.EXPENSE_ONE);
		}
		
		
		Expservice.add(ea, costId, expenseDetailsSmount);
		
		return loadadd(model);
		
	}
	//时间属性编辑器
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		
		bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
