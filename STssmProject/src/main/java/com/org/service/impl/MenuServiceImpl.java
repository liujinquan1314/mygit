package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Menu;
import com.org.dao.MenuDao;
import com.org.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao dao;
	
	@Override
	public List<Menu> list(Menu menu) {
		// TODO Auto-generated method stub
		return dao.list(menu);
	}

	@Override
	public Menu getInfo(Menu menu) {
		// TODO Auto-generated method stub
		return dao.getInfo(menu);
	}

	@Override
	public void add(Menu info) {
		// TODO Auto-generated method stub
		dao.add(info);
	}

	@Override
	public Menu findById(Integer menuId) {
		// TODO Auto-generated method stub
		return dao.findById(menuId);
	}

	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		try {
			dao.update(menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer menu) {
		// TODO Auto-generated method stub
		try {
			dao.delete(menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> findzi(Menu menu) {
		// TODO Auto-generated method stub
		return dao.findzi(menu);
	}

}
