package com.org.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.org.bean.Ant;
import com.org.bean.Menu;
import com.org.bean.Role;
import com.org.service.AntService;
import com.org.service.MenuService;
import com.org.service.RoleService;

@Controller
@RequestMapping("/ant/")
public class AntController {
	
	//角色的逻辑业务接口
	@Autowired
	private RoleService roleService;
	
	//菜单的逻辑业务接口
	@Autowired
	private MenuService menuService;
	
	//权限业务逻辑接口
		@Autowired
		private AntService antService;
	
	//查询角色
	@RequestMapping("list.do")
	public String list(Role info,Model model) {
		
		if(info==null) {
			info=new Role();
			
		}
		
		info.setRoleMark("0");
		List<Role> list=roleService.list(info);
		model.addAttribute("list",list);
		return "ant/anthority_list";
		
	}
	
	//角色变更
	@RequestMapping("loadchange.do")
	public String loadchange(Role info,Model model) {
		
		//角色的信息
		Role role=roleService.findant(info);
		
		//保存角色信息
		model.addAttribute("role", role);
		
		//查询菜单信息
		List<Menu>  list =menuService.list(null);
		
		//保存菜单信息
		model.addAttribute("list", list);
		
		//查询已有权限
		Ant ant=new Ant();
		
		//权限赋值已有roleid
		ant.setRoleId(info.getRoleId());
		
		List<Ant> rmlist=antService.list(ant);
		
		model.addAttribute("rmlist", rmlist);
		
		
		return "ant/anthority_change";
		
	}
	
	@RequestMapping("change.do")
	public String change(Integer roleId,Integer[] menuIds, Model model) {
		
		antService.add(roleId, menuIds);
		
		return list(null, model);
	}

	
	
}
