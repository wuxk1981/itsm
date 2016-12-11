package com.zdhy.platform.itsm.dao;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.PollingProject;
/**
 * 巡检项目DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-上午11:48:56
 * @version v1.0.0
 */
public interface PollingProjectMapper extends BaseMapper<PollingProject,String>{

	//根据巡检项目id查询巡检子项
	PollingProject selectSubitemListByProjectId(String projectId);
	
	//批删
	public int deleteByIds(String[] idArray);
	
	//根据模板id删除项目
	public int deleteByTemplateIds(String[] idArray);
	
	//根据项目名称和模板id查询巡检项目
	PollingProject selectByNameAndTemplateId(String name,String templateId);
}