package com.org.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ReportDao;
import com.org.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDao dao;

	@Override
	public List<Map<String, Object>> pieData() {
		 List<Map<String,Object>> data =new ArrayList<>();
	        List<Map<String, Object>> listdata=dao.count();
	        if(listdata.size()>0){
	            for(int i=0;i<listdata.size();i++){
	                Map<String,Object> map=new HashMap<>();
	                map.put("name", listdata.get(i).get("SEX"));
	                map.put("value", listdata.get(i).get("SEXCOUNT"));
	                data.add(map);
	            }
	        }
	        return data;
	}

}
