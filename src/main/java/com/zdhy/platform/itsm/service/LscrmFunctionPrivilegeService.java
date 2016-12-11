package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.service.impl.GeneralResult;



/**
 * 功能: 
 * LscrmFunctionPrivilegeService.java
 * 创建人： 吴心宽
 * 时间： 2016年11月21日-下午3:56:19
 * @version v1.0.0
 */
public interface LscrmFunctionPrivilegeService {

	GeneralResult<String> readAllPrivileges(int subSystemId);

}
