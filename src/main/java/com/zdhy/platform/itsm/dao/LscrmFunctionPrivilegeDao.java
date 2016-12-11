package com.zdhy.platform.itsm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdhy.platform.itsm.entity.tree.LscrmFunctionPrivilegeTree;


/**
 * 功能: 
 * LscrmFunctionPrivilegeDao.java
 * 创建人： 吴心宽
 * 时间： 2016年11月21日-下午3:49:38
 * @version v1.0.0
 */
public interface LscrmFunctionPrivilegeDao {

	 List<LscrmFunctionPrivilegeTree> readAllPrivileges(@Param("subSystemId")int subSystemId);
}
