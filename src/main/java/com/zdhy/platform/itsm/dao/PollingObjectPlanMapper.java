package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.PollingObjectPlan;
/**
 * 巡检对象计划关联DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-下午5:18:56
 * @version v1.0.0
 */
public interface PollingObjectPlanMapper extends BaseMapper<PollingObjectPlan,String>{

	//根据巡检对象id查询关联的巡检计划id
	List<String> selectByObjectId(String objectId);

	//根据巡检计划id删除
	void deleteByPlanId(String planId);
	
}