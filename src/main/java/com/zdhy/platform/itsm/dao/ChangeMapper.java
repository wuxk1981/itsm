package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Change;
/**
 * 换班表DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:43:56
 * @version v1.0.0
 */
public interface ChangeMapper extends BaseMapper<Change,String>{

	//查询自己的换班
	List<Change> queryMyChange(Map<String, Object> map);

}