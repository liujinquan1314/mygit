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
	//列出根节点
	@RequestMapping("list.do")
	public String list() {
		
		return "menu/menu_index";
		}
	//列出子节点
	@RequestMapping("menumain.do")
	public String menumain(Menu menu,Model model) {
		
		Menu info=null;
		
		if(menu!=null&&menu.getMenuId()!=null) {
			
			if(menu.getMenuId()==0) {
				
				info=new Menu();
				
				info.setMenuId(0);
				
				info.setMenuName("根节点");
				
				info.setParentMenuId(-1);
				
			}else {
				
				//不是根节点 进行查询
				
				info=menuService.getInfo(menu);
			}
		}
		model.addAttribute("menu", info);
		return "menu/menu_main";
	}
	//加载顶
	@RequestMapping("menutop.do")
	public String menutop() {
		
		return "menu/menu_top";
	}
	//加载左边
	@RequestMapping("menuleft.do")
	public String menuleft(Model model,Menu info) {
		
		List<Menu> list=menuService.list(info);
		
		model.addAttribute("list", list);
		
		return "menu/menu_left";
	}
	//添加2
	@RequestMapping("add.do")
	public String add(Menu info,Model model) {
		
		menuService.add(info);
		
		return menumain(null,model);
	}
	
	//添加1
	@RequestMapping("loadadd.do")
	public String loadadd(Menu info,Model model) {
		
		//查询全部
		List<Menu> list=menuService.list(info);
		
		model.addAttribute("list", list);
		
		model.addAttribute("menu", info);
		
		return "menu/menu_add";
	}
	//更新1
	@RequestMapping("loadupdate.do")
	public String loadupdate(Menu menu,Model model) {
		
		if(menu==null) {
			menu=new Menu();
		}
		
		Menu mymenu=menuService.findById(menu.getMenuId());
		
		//查询全部
		List<Menu> list=menuService.list(menu);
				
		model.addAttribute("list", list);
	
		model.addAttribute("menu",mymenu);
		
		return "menu/menu_update";
	}
	
	//更新2
	@RequestMapping("update.do")
	public String update(Menu menu,Model model ) {
		
		menuService.update(menu);
		
		return menumain(null,model);
		
		
	}
	
	//删除
	@RequestMapping("delete.do")
	public String delete(Menu menu,Model model ) {
		
		//获得当前菜单的子菜单
		List<Menu> list=menuService.findzi(menu);
		System.out.println("12111111111111111111111111111111111111111111111111111111111111111111111");
		if(list!=null&&list.size()>0) {
			model.addAttribute("info","对不起当前菜单还有子菜单！");
			
		}else {
			menuService.delete(menu.getMenuId());
			
			model.addAttribute("info","删除菜单成功！");
			
		}
		return "menu/menu_info";
	}
	
	
}
