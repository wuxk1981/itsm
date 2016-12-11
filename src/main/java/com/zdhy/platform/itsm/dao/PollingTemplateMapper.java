package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.PollingTemplate;
/**
 * 巡检模板DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-上午11:38:56
 * @version v1.0.0
 */
public interface PollingTemplateMapper extends BaseMapper<PollingTemplate,String>{
   
	//查询巡检模板下相应的巡检项目
	PollingTemplate selectProjectListByTemplateId(String templateId);
	
	//查询巡检模板下相应的巡检对象
	PollingTemplate selectObjectListByTemplateId(String templateId);
	
	//根据模板id数组查询该模板是否被巡检计划使用
	List<String> selectPlanNamesByTemplateIds(String[] idArray);
	
	//根据模板id查询该模板是否被巡检计划使用
	List<String> selectPlanNamesByTemplateId(String id);
	
	//根据模板id查询该模板下的巡检项目及子项
	List<Map<String,String>> selectProjectAndSubitem(String templateId);
	
	//批删
	public int deleteByIds(String[] idArray);
}