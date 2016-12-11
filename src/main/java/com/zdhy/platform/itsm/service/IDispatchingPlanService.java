package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.DispatchingPlan;

/**
 * 功能:调度计划业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午10:00:07
 * @version v1.0.0
 */
public interface IDispatchingPlanService extends BaseService<DispatchingPlan,String>{

	int insert(DispatchingPlan dispatchingPlan, String planId) throws Exception;

}

