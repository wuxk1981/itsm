package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.PollingObjectPlan;

/**
 * 功能:巡检对象与计划关联业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-下午6:12:31
 * @version v1.0.0
 */
public interface IPollingObjectPlanService extends BaseService<PollingObjectPlan,String>{

	int insert(String planId, String objectId) throws Exception;

}

