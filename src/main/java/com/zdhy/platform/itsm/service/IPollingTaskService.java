package com.zdhy.platform.itsm.service;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;

/**
 * 功能:巡检任务业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月28日-下午3:10:28
 * @version v1.0.0
 */
public interface IPollingTaskService {

	PageView findByMap(Map<String, Object> paramMap);

	List<Map<String, Object>> showMyTask(String polingMan);
}

