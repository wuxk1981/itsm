package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Instead;

/**
 * 功能:替班业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午11:45:42
 * @version v1.0.0
 */
public interface IInsteadService extends BaseService<Instead,String>{

	//值班管理查询所有的
	PageView findByMap(Map<String, Object> paramMap);

	//个人查询自己的
	PageView findMyInstead(String staff,Map<String, Object> paramMap);
}

