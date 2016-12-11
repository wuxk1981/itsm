package com.zdhy.platform.itsm.dao;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Shift;
/**
 * 班次表DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:37:56
 * @version v1.0.0
 */
public interface ShiftMapper extends BaseMapper<Shift,String>{

	//根据班次id查询排班
	Shift selectSchedulingsByShiftId(String shiftId);
}