package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.org.bean.Role;
import com.org.bean.User;
import com.org.service.RoleService;
import com.org.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private RoleService roleservice;
	@Autowired
	private UserService userservice;
	
	//全部显示
		@RequestMapping("list.do")
		public String list(User userInfo, Model model) {
			
			
			if(userInfo==null) {
				userInfo=new User();
			}
			userInfo.setUserMark("0");
			List<User> users=userservice.list(userInfo);
			
			model.addAttribute("users",users);
			
			return "user/user_list";
			
		}
		
		//查询
		@RequestMapping("find.do")
		public String find(User userName,Model model) {
			
			if(userName==null) {
				userName=new User();
			}
			List<User> users=userservice.findByName(userName);	
			model.addAttribute("users",users);
			return "user/user_list";
			
			
		}
		//增加1
		@RequestMapping("loadadd.do")
		public String add(Role roleInfo, Model model) {
			
			if(roleInfo==null) {
				roleInfo=new Role();
			}
			roleInfo.setRoleMark("0");
			List<Role> roles=roleservice.list(roleInfo);
			model.addAttribute("roles",roles);
			return "user/user_add";
			
		}
	//增加2
	@RequestMapping("add.do")
	public String add(User user,Model model) {
		user.setUserMark("0");
		userservice.add(user);
		
		 return list(null,model);
		
	}
	
	//删除操作
	@RequestMapping("delete.do")
	public String delete(Integer[] userId,Model model) {
		//System.out.println("111111111111111111111111111111111111111111111111111111111111111111");
		for(int i:userId) {
			System.out.println(i);
		}
		userservice.delete(userId);
		
		return list(null,model);
		
	}
	
	//修改操作1
	@RequestMapping("loadupdate.do")
	public String update(User user,Model model) {
		
		if(user==null) {
			user=new User();
		}
		User myuser=userservice.findById(user.getUserId());
	
		model.addAttribute("user",myuser);
	
		return "user/user_update";
		//修改操作2
	
	}
	@RequestMapping("update2.do")
	public String update2(User user,Model model) {
		
		
		userservice.update2(user);
		return list(null,model);
		
	}
	
	//检查用户名密码

	@RequestMapping("check.do")
	public @ResponseBody String  check(User user) {
	
		User info=userservice.getUser(user);
		
		if(info!=null) {
			
			return "账号已经存在";
		}else {
			
			return "恭喜您账号可以使用";
		}
	}
	
	
	
	
}
