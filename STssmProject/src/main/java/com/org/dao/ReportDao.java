package com.org.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface ReportDao {
	
	//ͳ����Ů�û�����
    @Select("select case when user_sex='Ů' then 'Ů' when user_sex='��' then '��' end as SEX,count(user_sex) as SEXCOUNT from user_info group by user_sex")
    List<Map<String,Object>> count();

}
