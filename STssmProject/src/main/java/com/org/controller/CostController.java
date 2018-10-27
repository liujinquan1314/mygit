package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.bean.Cost;
import com.org.bean.Role;
import com.org.service.CostService;

@Controller
@RequestMapping("/cost/")
public class CostController {
	
	@Autowired
	private CostService costservice;
	

	//查询列出全部
		@RequestMapping("list.do")
		public String list(Cost cost, Model model) {
			if(cost==null) {
				cost=new Cost();
			}
			cost.setCostMark("0");
			List<Cost> costs=costservice.list(cost);
			
			model.addAttribute("costs",costs);
			
			return "cost/cost_list";
			
			
		}
	
		//增加1
		@RequestMapping("loadadd.do")
		public String add() {
					
			return "cost/cost_add";
					
		}
		//增加2
		@RequestMapping("add.do")
		public String add(Cost cost,Model model) {
			cost.setCostMark("0");
			costservice.add(cost);
			return list(null,model);
			
		}
		
		//查询单个
		@RequestMapping("find.do")	
		public String find(Cost costname,Model model) {
			System.out.println(costname);
			if(costname==null) {
				costname=new Cost();
			}
			List<Cost> costs=costservice.findByName(costname);	
			model.addAttribute("costs",costs);
			return "cost/cost_list";
					
			}
		//修改1
		@RequestMapping("loadupdate.do")
		public String update1(Cost cost, Model model) {
			
			if(cost==null) {
				cost=new Cost();
			}
			
			Cost mycost=costservice.findById(cost.getCostId());
		
			model.addAttribute("cost",mycost);
			return "cost/cost_update";
			
		}
		//修改2
		@RequestMapping("loadupdate2.do")
		public String update2(Cost cost,Model model) {
			/*roleservice.update2(role);*/
			costservice.update2(cost);
			
			return list(null,model);
	
		}
		//删除
	
		@RequestMapping("delete.do")
		public String delete(Integer[] costId,Model model ) {
			
			costservice.delete(costId);
			return list(null,model);
			
			
		}
		

}
