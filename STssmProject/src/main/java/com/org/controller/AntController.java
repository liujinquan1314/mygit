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
	
	//��ɫ���߼�ҵ��ӿ�
	@Autowired
	private RoleService roleService;
	
	//�˵����߼�ҵ��ӿ�
	@Autowired
	private MenuService menuService;
	
	//Ȩ��ҵ���߼��ӿ�
		@Autowired
		private AntService antService;
	
	//��ѯ��ɫ
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
	
	//��ɫ���
	@RequestMapping("loadchange.do")
	public String loadchange(Role info,Model model) {
		
		//��ɫ����Ϣ
		Role role=roleService.findant(info);
		
		//�����ɫ��Ϣ
		model.addAttribute("role", role);
		
		//��ѯ�˵���Ϣ
		List<Menu>  list =menuService.list(null);
		
		//����˵���Ϣ
		model.addAttribute("list", list);
		
		//��ѯ����Ȩ��
		Ant ant=new Ant();
		
		//Ȩ�޸�ֵ����roleid
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
