package com.zdhy.platform.itsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.ResourcesMapper;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.entity.ResourcesRole;
import com.zdhy.platform.itsm.service.ResourcesService;

@Transactional
@Service("resourcesService")
public class ResourcesServiceImpl extends BaseServiceImpl<Resources, String> implements ResourcesService {
	@Autowired
	private ResourcesMapper resourcesMapper;

	public List<Resources> queryByParentId(Resources resources)
	{
		return resourcesMapper.queryByParentId(resources);
	}
	
	public void add(Resources t) throws Exception {
		this.resourcesMapper.insert(t);
	}

	
	public void updateSortOrder(List<Resources> resourcess) {
		for (Resources m : resourcess) {
			resourcesMapper.updateSortOrder(m);
		}
	}

	
	public List<Resources> findAccountResourcess(String accountId) {
		return resourcesMapper.findAccountResourcess(accountId);
	}

	
	public List<Resources> findRoleRes(String roleId) {
		return resourcesMapper.findRoleRes(roleId);
	}

	
	public void addRoleRes(String roleId,List<String> list) {
		resourcesMapper.deleteResourcesRole(roleId);
		for (String string : list) {
			ResourcesRole rr = new ResourcesRole();
			rr.setRoleId(roleId);
			rr.setResId(string);
			resourcesMapper.addRoleRes(rr);
		}
	}

	
	public int getMaxLevel() {
		return resourcesMapper.getMaxLevel();
	}

	
	public Resources isExist(String resourcesName) {
		return resourcesMapper.isExist(resourcesName);
	}

	@Override
	public BaseMapper<Resources, String> getDao() {
		return resourcesMapper;
	}
}
