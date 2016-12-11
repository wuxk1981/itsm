package com.zdhy.platform.itsm.core.base;

import java.util.List;
import java.util.Map;


/**
 * 所有的Mapper继承这个接口
 * 已经实现民基本的 增,删,改,查接口,不需要重复写
 * @version 1.0v
 */
public interface BaseMapper<Model, PK> extends Base<Model, PK> {
	
	/**
	 * 返回分页后的数据
	 * @param List
	 * @param t
	 * @return
	 */
	public List<Model> query(Map<String, Object> map);
	List<Model> findList(Model model);
}