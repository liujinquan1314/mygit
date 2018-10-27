package com.org.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.bean.AudHistory;
import com.org.bean.Cost;
import com.org.bean.Expense;
import com.org.service.ManageService;

@Controller
@RequestMapping("/expense/")
public class MyOperateController {
	
	@Autowired
	private ManageService manageService;
	
	//报销加载
	@RequestMapping("mylist.do")
	public String myCost(Expense expense, Model model) {

		if(expense==null) {
			expense=new Expense();
		}
		List<Expense> manage=manageService.list(expense);
		model.addAttribute("list",manage);
		return "expense/expense_mylist";
	}
	
	//查询报销单
		@RequestMapping("mylist1.do")
		public String mylist(Expense expense, Model model) {
				
			if(expense==null) {
				expense=new Expense();
			}
				List<Expense> manage=manageService.findByName(expense);
				
				model.addAttribute("list",manage);
				
				return "expense/expense_mylist";
			}
	
	//查看报销单详情
		@RequestMapping("myshow.do")
		public String myshow(AudHistory audHistory ,Expense expense,Model model) {
				
			Expense ex=manageService.findById(expense.getExpenseId());
			
			List<Cost> eds=manageService.findcost(expense.getExpenseId());

			List<AudHistory> au=manageService.findadut(audHistory);
	
			model.addAttribute("exp",ex);
			
			model.addAttribute("list",eds);
			
			model.addAttribute("historyList",au);
				
				return "expense/expense_myshow";
			}
		
	//加载我的审核
		@RequestMapping("myauditlist.do")
		public String myauditlist(Expense expense, Model model) {
			if(expense==null) {
				expense=new Expense();
			}
			List<Expense> manage=manageService.list(expense);
			model.addAttribute("list",manage);	
			return "expense/expense_myauditlist";
			
		}
		
	
		//查询我的报销单
				@RequestMapping("mylist2.do")
				public String mylist1(Expense expense, Model model) {
						
					if(expense==null) {
						expense=new Expense();
					}
						List<Expense> manage=manageService.findByName(expense);
						
						model.addAttribute("list",manage);
						
						return "expense/expense_myauditlist";
					}
		
		//查看我的报销单明细
		@RequestMapping("myauditshow.do")
		public String myauditshow(AudHistory audHistory ,Expense expense,Model model) {
			
			Expense ex=manageService.findById(expense.getExpenseId());
			
			List<Cost> eds=manageService.findcost(expense.getExpenseId());

			List<AudHistory> au=manageService.findadut(audHistory);
	
			model.addAttribute("exp",ex);
			
			model.addAttribute("list",eds);
			
			model.addAttribute("historyList",au);
				
				return "expense/expense_myauditshow";
			}
		//查询我的报销单
		@RequestMapping("list8.do")
		public String list8(Expense expense, Model model) {

			if(expense==null) {
				expense=new Expense();
			}
			List<Expense> manage=manageService.list(expense);
			model.addAttribute("list",manage);
			return "expense/expense_list";
		}
		
		//查询报销单名称
				@RequestMapping("list9.do")
				public String list9(Expense expense, Model model) {
						
					if(expense==null) {
						expense=new Expense();
					}
						List<Expense> manage=manageService.findByName(expense);
						
						model.addAttribute("list",manage);
						
						return "expense/expense_mylist";
					}
		
				//查看报销单详情
				@RequestMapping("show.do")
				public String show(AudHistory audHistory ,Expense expense,Model model) {
						
					Expense ex=manageService.findById(expense.getExpenseId());
					
					List<Cost> eds=manageService.findcost(expense.getExpenseId());

					List<AudHistory> au=manageService.findadut(audHistory);
			
					model.addAttribute("exp",ex);
					
					model.addAttribute("list",eds);
					
					model.addAttribute("historyList",au);
						
						return "expense/expense_show";
					}
		
		//时间属性编辑器
		@InitBinder
		public void initBinder(ServletRequestDataBinder bin) {
			
			bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}

}
