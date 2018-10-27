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
public class AuditFinanceController {
	
	@Autowired
	private ManageService manageService;
	
	//财务审核信息加载
		@RequestMapping("Finance.do")
		public String Finance(Expense expense, Model model) {
			
			if(expense==null) {
				expense=new Expense();
			}
			List<Expense> manage=manageService.list(expense);
			
			model.addAttribute("list",manage);
			
			return"expense/expense_audit_finance";
			
		}
		
		//查找报销单
		@RequestMapping("loadAuditFinance.do")
		public String loadAuditManager(Expense expense, Model model) {
			
			if(expense==null) {
				expense=new Expense();
			}
			List<Expense> manage=manageService.findByName(expense);
			
			model.addAttribute("list",manage);
			
			return "expense/expense_audit_manager";
		}
		
		
		//财务经理审核信息加载
		@RequestMapping("loadFinance.do")
		public String loadManager(Expense expense, Model model,AudHistory audHistory ) {
			
			if(expense==null) {
				expense=new Expense();
			}
			Expense myuser=manageService.findById(expense.getExpenseId());
			
			List<Cost> ed=manageService.findcost(expense.getExpenseId());
			
			List<AudHistory> au=manageService.findadut(audHistory);
			
			model.addAttribute("historyList",au);
			
			
			model.addAttribute("list",ed);
		
			model.addAttribute("exp",myuser);
			
			return "expense/expense_finance";
			
		}
		
		//财务审核auditFinance.do
	
		@RequestMapping("auditFinance.do")
		public String submit(AudHistory audHistory ,Expense expense,Model model) {
			
			Expense ex=manageService.findById(expense.getExpenseId());
			
			List<Cost> eds=manageService.findcost(expense.getExpenseId());
			
			/*audHistory.setExpenseTime(ex.getExpenseTime());
			manageService.addhis(audHistory);*/
			
			List<AudHistory> au=manageService.findadut(audHistory);
			
			ex.setExpenseState(audHistory.getAuditState());
			
			manageService.updateExpense(ex);
			
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
