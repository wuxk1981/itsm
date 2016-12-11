package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.entity.ResourcesRole;

public interface ResourcesMapper extends BaseMapper<Resources,String> {

	/**
	 * 
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:27:28
	 * @version 1.0.0
	 * @param resources
	 */
	void updateSortOrder(Resources resources);

	/**
	 * 
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:27:24
	 * @version 1.0.0
	 * @param name
	 * @return
	 */
	public Resources isExist(String name);

	/**
	 * 
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:27:20
	 * @version 1.0.0
	 * @return
	 */
	public int getMaxLevel();

	/**
	 * 根据账号Id获取该用户的权限
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:26:43
	 * @version 1.0.0
	 * @param accountId
	 * @return
	 */
	public List<Resources> findAccountResourcess(String accountId);

	/**
	 * 根据角色id获取权限
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:26:02
	 * @version 1.0.0
	 * @param roleId
	 * @return
	 */
	public List<Resources> findRoleRes(String roleId);
	
	/**
	 * 根据父id获取资源列表
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:27:42
	 * @version 1.0.0
	 * @param resources
	 * @return
	 */
	public List<Resources> queryByParentId(Resources resources);
	/**
	 * 更新菜单排序号
	 * 
	 * @author lanyuan 
	 * @Email：mmm333zzz520@163.com 
	 * @date：2014-04-12
	 * @param resourceVOs
	 */
	public void addRoleRes(ResourcesRole rr);

	/**
	 * 
	 * 创建人： 吴心宽
	 * 时间： 2016年11月22日-下午5:28:16
	 * @version 1.0.0
	 * @param roleId
	 */
	public void deleteResourcesRole(String roleId);
}
