package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.PollingPlan;
/**
 * 巡检计划DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午3:30:56
 * @version v1.0.0
 */
public interface PollingPlanMapper extends BaseMapper<PollingPlan,String> {
    //带分页条件查询
	List<Map<String,Object>> queryByPage(Map<String, Object> map);
	
	//根据巡检计划查询调度计划
	PollingPlan findByPollPlanId(String pollPlanId);
	
	//根据巡检计划id查询巡检对象及模板
	List<Map<String,String>> selectTemplateAndObject(String id);
}