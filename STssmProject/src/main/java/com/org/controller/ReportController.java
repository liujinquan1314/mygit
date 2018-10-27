package com.org.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.service.ReportService;

@Controller
@RequestMapping("/report/")
public class ReportController {
	
	@Autowired
	private ReportService reportservice;
	
	
	
@RequestMapping("load.do")
public String load() {
	
	
	return "report/userSexEcharts";
	
	
}
	
	
	/**
     * 获取饼状图数据
     * @return
     */
    @RequestMapping(value="echartsData",method=RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> initChart(){
        return reportservice.pieData();
    }

}
