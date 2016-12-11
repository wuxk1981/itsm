package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Technology;



/**
 * 功能: 
 * ITechnologyService.java
 * 创建人： 吴心宽
 * 时间： 2016年11月9日-上午10:23:34
 * @version v1.0.0
 */
public interface ITechnologyService extends BaseService<Technology,String>{


	Technology get(String id);

	Pagination<Technology> findPage(Map<String, Object> resultMap,
			Integer pageNo, int pageSize);

	PageView findTechnologyByMap(Map<String, Object> paramMap);

	Map<String, Object> deleteTechnologyByIds(String ids);

}
