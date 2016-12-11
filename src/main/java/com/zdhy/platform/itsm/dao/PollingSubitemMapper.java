package com.zdhy.platform.itsm.dao;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.PollingSubitem;
/**
 * 巡检子项DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午1:32:56
 * @version v1.0.0
 */
public interface PollingSubitemMapper extends BaseMapper<PollingSubitem,String> {
    
	//根据项目id删除子项
	public int deleteByProjectId(String projectId);
	
	//批删
	public int deleteByIds(String[] idArray);
	
	//根据模板id删除子项 
	public int deleteByTemplateIds(String[] idArray);
	//根据项目id数组删除子项
	public int deleteByProjectIds(String[] idArray);
}