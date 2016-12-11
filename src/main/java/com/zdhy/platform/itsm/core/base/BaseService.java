package com.zdhy.platform.itsm.core.base;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;

/**
 * 所有服务接口都要继承这个
 * 
 * @author lanyuan
 * @date 2014-2-11
 * @Email: mmm333zzz520@163.com
 * @version 1.0v
 * @param <T>
 */
public interface BaseService<Model, PK> extends Base<Model, PK> {
	/**
	 * 返回分页后的数据
	 * 
	 * @param pageView
	 * @param t
	 * @return
	 */
	public PageView query(PageView pageView, Model model);
}
