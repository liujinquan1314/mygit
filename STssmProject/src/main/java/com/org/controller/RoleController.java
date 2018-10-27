package com.org.controller;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.org.bean.Role;
import com.org.service.RoleService;

@Controller
@RequestMapping("/role/")
public class RoleController {
	
	@Autowired
	private RoleService roleservice;
	//增加
	@RequestMapping("add.do")
	public String add(Role role,Model model) {
		role.setRoleMark("0");
		roleservice.add(role);
		return list(null,model);
		
	}
	//增加
	@RequestMapping("loadadd.do")
	public String add() {
		
		return "role/role_add";
		
	}
//列出单个
@RequestMapping("find.do")	
public String find(Role roleName,Model model) {
	if(roleName==null) {
		roleName=new Role();
	}
	List<Role> roles=roleservice.findByName(roleName);	
	model.addAttribute("roles",roles);
	return "role/role_list";
			
	}
	//查询列出全部
	@RequestMapping("list.do")
	public String list(Role roleInfo, Model model) {
		if(roleInfo==null) {
			roleInfo=new Role();
		}
		roleInfo.setRoleMark("0");
		List<Role> roles=roleservice.list(roleInfo);
		
		model.addAttribute("roles",roles);
		
		return "role/role_list";
		
		
	}
	//删除
	@RequestMapping("delete.do")
	public String delete(Integer[] roleId,Model model ) {
		
		roleservice.delete(roleId);
		return list(null,model);
		
		
	}
	//修改1
	@RequestMapping("loadupdate.do")
	public String loadupdate(Role role,Model model) {
		
		if(role==null) {
			role=new Role();
		}
		
		Role myrole=roleservice.findById(role.getRoleId());
	
		model.addAttribute("role",myrole);
		return "role/role_update";
	
	}
	//修改2
	@RequestMapping("loadupdate2.do")
	public String loadupdate2(Role role,Model model) {
	//System.out.println("1233333333333333333333");
		roleservice.update2(role);
		return list(null,model);
		
	}
	
}
