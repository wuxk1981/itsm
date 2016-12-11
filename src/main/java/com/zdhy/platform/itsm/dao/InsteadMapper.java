package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Instead;
/**
 * 替班表DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:45:56
 * @version v1.0.0
 */
public interface InsteadMapper extends BaseMapper<Instead,String> {

	//查询自己的替班
	List<Instead> queryMyInstead(Map<String, Object> map);
    
}