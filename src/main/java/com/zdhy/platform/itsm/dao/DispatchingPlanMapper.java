package com.zdhy.platform.itsm.dao;

import java.util.Date;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.DispatchingPlan;
/**
 * 调度计划DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午3:27:56
 * @version v1.0.0
 */
public interface DispatchingPlanMapper extends BaseMapper<DispatchingPlan,String>{

	//根据巡检计划id删除调度计划
	void deleteByPollingPlanId(String planId);
    
	void updatePollingPlan(Date endDate,String planId);
}