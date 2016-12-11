package com.zdhy.platform.itsm.service;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.PollingTemplate;

/**
 * 功能:巡检模板业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:16:08
 * @version v1.0.0
 */
public interface IPollingTemplateService extends BaseService<PollingTemplate,String>{

	//查询巡检模板下相应的巡检项目
	PollingTemplate listProjectsByTemplateId(String templateId);
		
	//查询巡检模板下相应的巡检对象
	PollingTemplate listObjectsByTemplateId(String templateId);

	//根据模板id查询该模板下的巡检项目及子项
	List<Map<String,String>> findProjectAndSubitem(String templateId);
	int deleteTemplatesByIds(String ids);
	
//	Map<String,Object> selectTemplateByName(String name);
}

