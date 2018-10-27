package com.org.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.bean.Expense;
import com.org.bean.Role;
import com.org.bean.Salary;
import com.org.bean.User;
import com.org.service.SalaryService;
import com.org.service.UserService;

@Controller
@RequestMapping("/salary/")
public class SalaryController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private SalaryService salaryservice;
	
	//加载用户
	@RequestMapping("loadadd.do")
	public String loadadd(User userinfo, Model model) {
		
		if(userinfo==null) {
			userinfo=new User();
		}
		userinfo.setUserMark("0");
		List<User> users=userservice.list(userinfo);
		model.addAttribute("users",users);
	
		
		return "salary/salary_add";
		
	}
	//增加工资
		@RequestMapping("add.do")
		public String add(Salary salary) {
			
			
			salaryservice.add(salary);
			
			
			 return "salary/salary_add";
			
		}
	
	//薪资查询列表
		@RequestMapping("find.do")
		
		public String find(Salary salary,Model model) {
			
			if(salary==null) {
				salary=new Salary();
			}
			List<Salary> salarys=salaryservice.list(salary);
			
			model.addAttribute("salarys",salarys);
			
			return "salary/salary_list";
			
			
		}
	//名字查询工资
		@RequestMapping("check.do")
		public String check(Salary salary, Model model) {
			
			if(salary==null) {
				salary=new Salary();
			}
			List<Salary> salarys=salaryservice.findByName(salary);
			
			model.addAttribute("salarys",salarys);
			
			return "salary/salary_list";
		}

	//时间属性编辑器
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		
		bin.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
