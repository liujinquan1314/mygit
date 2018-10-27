package com.org.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Ant;
import com.org.dao.AntDao;
import com.org.service.AntService;
@Service
public class AntServiceImpl implements AntService {
	
	@Autowired
	private AntDao dao;
	
	
	@Override
	public List<Ant> list(Ant info) {
		// TODO Auto-generated method stub
		return dao.list(info);
	}

	@Override
	public void add(Integer roleId,Integer[] menuIds) {
		// TODO Auto-generated method stub
		
		//先删除
		dao.delete(roleId);
		
		//在增加
		for(Integer menuId:menuIds) {
			
			Ant info=new Ant();
			
			info.setMenuId(menuId);
			info.setRoleId(roleId);
			
			dao.add(info);
		}
	}

	@Override
	public List<Map> getMenuList(Integer roleId) {
		// TODO Auto-generated method stub
		return dao.getMenuList(roleId);
		
	}

}
