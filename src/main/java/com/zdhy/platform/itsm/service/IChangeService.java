package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Change;

/**
 * 功能:换班业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午11:30:48
 * @version v1.0.0
 */
public interface IChangeService extends BaseService<Change,String>{

	//值班管理界面查询所有
	PageView findByMap(Map<String, Object> paramMap);

	//个人界面查询自己的
	PageView findMyChange(String staff, Map<String, Object> paramMap);

}

