package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.PollingProject;

/**
 * 功能:巡检项目业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:36:31
 * @version v1.0.0
 */
public interface IPollingProjectService extends BaseService<PollingProject,String>{

	
	//根据巡检项目id查询巡检子项
	PollingProject listItemsByProjectId(String projectId);

	int insert(PollingProject pollingProject, String templateId)
			throws Exception;

	int deleteProjectsByIds(String ids);
	
	//根据模板id删除
	int deleteByTemplateIds(String[] idArray);
//	Map<String,Object> selectProjectByName(String name);
}

