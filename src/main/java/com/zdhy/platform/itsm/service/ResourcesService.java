package com.zdhy.platform.itsm.service;


import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.Resources;

public interface ResourcesService extends BaseService<Resources,String>{
	//<!-- 根据账号Id获取该用户的权限-->
	public List<Resources> findAccountResourcess(String accountId);
	/**
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2014-2-25
	 * @return
	 */
	public List<Resources> findRoleRes(String roleId);
	
	public List<Resources> queryByParentId(Resources resources);
	/**
	 * 更新菜单排序号
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2014-04-12
	 * @param resourceVOs
	 */
	void updateSortOrder(List<Resources> menus);
	public void addRoleRes(String roleId,List<String> list);

	public Resources isExist(String menuName);
	public  int  getMaxLevel();
}
