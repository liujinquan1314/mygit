package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.reflect.MethodDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.bean.Menu;
import com.org.bean.Role;
import com.org.service.MenuService;

@Controller
@RequestMapping("/menu/")
public class MenuController {

	@Autowired
	private MenuService menuService;
	//�г����ڵ�
	@RequestMapping("list.do")
	public String list() {
		
		return "menu/menu_index";
		}
	//�г��ӽڵ�
	@RequestMapping("menumain.do")
	public String menumain(Menu menu,Model model) {
		
		Menu info=null;
		
		if(menu!=null&&menu.getMenuId()!=null) {
			
			if(menu.getMenuId()==0) {
				
				info=new Menu();
				
				info.setMenuId(0);
				
				info.setMenuName("���ڵ�");
				
				info.setParentMenuId(-1);
				
			}else {
				
				//���Ǹ��ڵ� ���в�ѯ
				
				info=menuService.getInfo(menu);
			}
		}
		model.addAttribute("menu", info);
		return "menu/menu_main";
	}
	//���ض�
	@RequestMapping("menutop.do")
	public String menutop() {
		
		return "menu/menu_top";
	}
	//�������
	@RequestMapping("menuleft.do")
	public String menuleft(Model model,Menu info) {
		
		List<Menu> list=menuService.list(info);
		
		model.addAttribute("list", list);
		
		return "menu/menu_left";
	}
	//���2
	@RequestMapping("add.do")
	public String add(Menu info,Model model) {
		
		menuService.add(info);
		
		return menumain(null,model);
	}
	
	//���1
	@RequestMapping("loadadd.do")
	public String loadadd(Menu info,Model model) {
		
		//��ѯȫ��
		List<Menu> list=menuService.list(info);
		
		model.addAttribute("list", list);
		
		model.addAttribute("menu", info);
		
		return "menu/menu_add";
	}
	//����1
	@RequestMapping("loadupdate.do")
	public String loadupdate(Menu menu,Model model) {
		
		if(menu==null) {
			menu=new Menu();
		}
		
		Menu mymenu=menuService.findById(menu.getMenuId());
		
		//��ѯȫ��
		List<Menu> list=menuService.list(menu);
				
		model.addAttribute("list", list);
	
		model.addAttribute("menu",mymenu);
		
		return "menu/menu_update";
	}
	
	//����2
	@RequestMapping("update.do")
	public String update(Menu menu,Model model ) {
		
		menuService.update(menu);
		
		return menumain(null,model);
		
		
	}
	
	//ɾ��
	@RequestMapping("delete.do")
	public String delete(Menu menu,Model model ) {
		
		//��õ�ǰ�˵����Ӳ˵�
		List<Menu> list=menuService.findzi(menu);
		System.out.println("12111111111111111111111111111111111111111111111111111111111111111111111");
		if(list!=null&&list.size()>0) {
			model.addAttribute("info","�Բ���ǰ�˵������Ӳ˵���");
			
		}else {
			menuService.delete(menu.getMenuId());
			
			model.addAttribute("info","ɾ���˵��ɹ���");
			
		}
		return "menu/menu_info";
	}
	
	
}
