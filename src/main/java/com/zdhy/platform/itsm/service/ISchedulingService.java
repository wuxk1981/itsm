package com.zdhy.platform.itsm.service;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.Scheduling;

/**
 * 功能:值班业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-上午11:10:17
 * @version v1.0.0
 */
public interface ISchedulingService extends BaseService<Scheduling,String>{

	//值班表管理首页加载值班
//	List<Map<String, Object>> listSchedulings();

	//员工点击我的值班表加载自己的值班
	List<Map<String, Object>> listSchedulingByDutyMan(String dutyMan);

	List<Map<String, Object>> showSchedulings(Map<String, Object> paramMap);

}

