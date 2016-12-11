package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.PollingTask;

/**
 * 功能:巡检任务DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月28日-下午2:08:14
 * @version v1.0.0
 */
public interface PollingTaskMapper extends BaseMapper<PollingTask,String>{
	//多条件查询
	List<PollingTask> query(Map<String, Object> map);
	
	//根据巡检人查询
	List<Map<String, Object>> selectByPollingMan(String pollingMan);
}

