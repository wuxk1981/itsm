package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Technology;

/**
 * 技术服务DAO 创建人： 袁乐乐 时间： 2016年11月7日-上午11:40:56
 * 
 * @version v1.0.0
 */
public interface TechnologyMapper extends BaseMapper<Technology, String> {

	List<Technology> findTechnologyByMap(Technology technology);

}