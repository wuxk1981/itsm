package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.PollingSubitem;

/**
 * 功能:巡检项目子项业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:50:17
 * @version v1.0.0
 */
public interface IPollingSubitemService extends BaseService<PollingSubitem,String>{

	//根据项目id删除子项
	public int deleteSubitemsByProjectId(String projectId);

	int insert(PollingSubitem pollingSubitem, String projectId)
			throws Exception;

	int deleteSubitemsByIds(String ids);
	//根据模板id删除
	int deleteByTemplateIds(String[] idArray);

	//根据项目id删除
	void deleteByProjectIds(String[] idArray);
}

