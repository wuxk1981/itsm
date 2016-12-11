package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.PollingObject;

/**
 * 功能:巡检对象业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:27:03
 * @version v1.0.0
 */
public interface IPollingObjectService extends BaseService<PollingObject,String>{

	int insert(PollingObject pollingObject, String templateId,String planId) throws Exception;
}

