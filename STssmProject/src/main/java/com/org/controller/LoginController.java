package com.org.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.org.bean.User;
import com.org.service.AntService;
import com.org.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AntService authorityService;
	
	@RequestMapping("login.do")
	public String login(User info,HttpSession session,Model model) {
		
				//查询用户名密码
				User user=userService.login(info);
				System.out.println(user);
				if(user!=null) {
					
					//把用户信息放到session中
					session.setAttribute("user", user);
					
					//查询用户对应的菜单
					List<Map> list=authorityService.getMenuList(user.getRoleId());
					
					System.out.println(list);
					
					model.addAttribute("list", list);
					
					return"main/index";
				}
				return "redirect:login.jsp";
			}
	
	@RequestMapping("bootm.do")
	public String bootm() {
		
		return "main/bootm";
	}
	
	@RequestMapping("exit.do")
	public String exit(HttpSession session) {

	session.invalidate();
	return "redirect:login.jsp";
		
	}
	@RequestMapping("imf.do")
	public String imforation(User userName,Model model) {
		

		if(userName==null) {
			userName=new User();
		}
		List<User> users=userService.findByName(userName);	
		model.addAttribute("users",users);
		
		return "user/user_list";
		
		
	}
	

}
