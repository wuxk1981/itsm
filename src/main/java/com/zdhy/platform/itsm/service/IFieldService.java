package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Field;



/**
 * 功能: 
 * IFieldService.java
 * 创建人： 吴心宽
 * 时间： 2016年11月9日-上午10:23:34
 * @version v1.0.0
 */
public interface IFieldService extends BaseService<Field,String>{


	Field get(String id);

	Pagination<Field> findPage(Map<String, Object> resultMap,
			Integer pageNo, int pageSize);

	PageView findFieldByMap(Map<String, Object> paramMap);

	Map<String, Object> deleteFieldByIds(String ids);

}
