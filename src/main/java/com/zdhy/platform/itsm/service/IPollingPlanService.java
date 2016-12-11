package com.zdhy.platform.itsm.service;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.PollingPlan;

/**
 * 功能:巡检计划业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:45:47
 * @version v1.0.0
 */
public interface IPollingPlanService extends BaseService<PollingPlan,String>{

	//根据巡检计划查询调度计划
	PollingPlan findDispatchingPlan(String pollPlanId);

	//根据巡检计划id查询巡检对象及模板
	List<Map<String,String>> findTemplateAndObject(String id);

	void startPollingPlan(String id);
	
//	Map<String,Object> selectPlanByName(String name);
}

