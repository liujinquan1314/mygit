package com.org.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ReportDao {
	
	//统计男女用户人数
    @Select("select case when user_sex='女' then '女' when user_sex='男' then '男' end as SEX,count(user_sex) as SEXCOUNT from user_info group by user_sex")
    List<Map<String,Object>> count();

}
