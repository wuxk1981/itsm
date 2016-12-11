package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Logbook;
/**
 * 值班日志表DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:40:56
 * @version v1.0.0
 */
public interface LogbookMapper extends BaseMapper<Logbook,String>{

	//查询自己的值班日志
	List<Logbook> queryMyLogbook(Map<String, Object> map);
   
}