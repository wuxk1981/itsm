package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Catalogue;


/**
 * 功能: 
 * ICatalogueService.java
 * 创建人： 吴心宽
 * 时间： 2016年11月9日-上午10:23:34
 * @version v1.0.0
 */
public interface ICatalogueService extends BaseService<Catalogue,String>{


	Catalogue get(String id);

	Pagination<Catalogue> findPage(Map<String, Object> resultMap, Integer pageNo,
			int pageSize);

	PageView findCatalogueByMap(Map<String, Object> paramMap);

	Map<String, Object> deleteCatalogueByIds(String ids);

}
