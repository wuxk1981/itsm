package com.zdhy.platform.itsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.zdhy.platform.itsm.dao.LscrmFunctionPrivilegeDao;
import com.zdhy.platform.itsm.entity.tree.LscrmFunctionPrivilegeTree;
import com.zdhy.platform.itsm.service.LscrmFunctionPrivilegeService;

/**
 * 功能: LscrmFunctionPrivilegeServiceImpl.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月21日-下午3:55:57
 * 
 * @version v1.0.0
 */
public class LscrmFunctionPrivilegeServiceImpl implements LscrmFunctionPrivilegeService {
	@Autowired
	private LscrmFunctionPrivilegeDao lscrmFunctionPrivilegeDao;

	@Override
	public GeneralResult<String> readAllPrivileges(int subSystemId) {
		List<LscrmFunctionPrivilegeTree> privilegeTrees = lscrmFunctionPrivilegeDao.readAllPrivileges(subSystemId);

		return new GeneralResult<String>(JSON.toJSONString(privilegeTrees));
	}
}
