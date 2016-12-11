package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Business;



/**
 * 功能: 业务服务
 * IBusinessService.java
 * 创建人： 吴心宽
 * 时间： 2016年11月9日-上午10:23:34
 * @version v1.0.0
 */
public interface IBusinessService extends BaseService<Business,String>{


	Business get(String id);

	Pagination<Business> findPage(Map<String, Object> resultMap,
			Integer pageNo, int pageSize);

	PageView findBusinessByMap(Map<String, Object> paramMap);

	Map<String, Object> deleteBusinessByIds(String ids);

}
