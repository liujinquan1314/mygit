package com.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bean.Cost;
import com.org.bean.Role;
import com.org.dao.CostDao;
import com.org.service.CostService;
@Service
public class CostServiceImpl implements CostService {
	
	@Autowired
	private CostDao dao;

	@Override
	public List<Cost> list(Cost cost) {
		// TODO Auto-generated method stub
		return dao.list(cost);
	}

	@Override
	public void add(Cost cost) {
		// TODO Auto-generated method stub
		try {
			dao.add(cost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cost> findByName(Cost cost) {
		// TODO Auto-generated method stub
		return dao.findByName(cost);
	}

	@Override
	public Cost findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void update2(Cost cost) {
		// TODO Auto-generated method stub
		try {
			dao.update2(cost);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer[] costId) {
		// TODO Auto-generated method stub
		for(Integer id:costId) {
			Cost info=new Cost();
			
			info.setCostId(id);
			
			info.setCostMark("1");
			try {
				dao.update2(info);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
