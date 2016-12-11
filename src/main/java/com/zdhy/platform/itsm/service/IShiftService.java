package com.zdhy.platform.itsm.service;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.Shift;

/**
 * 功能:班次业务接口
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-上午10:50:17
 * @version v1.0.0
 */
public interface IShiftService extends BaseService<Shift,String>{

	//查询班次下的排班
	Shift listSchedulingsByShiftId(String shiftId);
	
}

