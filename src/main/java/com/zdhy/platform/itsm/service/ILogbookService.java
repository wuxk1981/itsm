package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Logbook;

/**
 * 功能:值班日志业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午11:53:10
 * @version v1.0.0
 */
public interface ILogbookService extends BaseService<Logbook,String>{
	
	//值班管理界面查询
	PageView findByMap(Map<String, Object> paramMap);

	//个人查询自己的
	PageView findMyLogbook(String staff, Map<String, Object> paramMap);
}

