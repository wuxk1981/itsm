package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Scheduling;
/**
 * 排班表DAO
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:42:56
 * @version v1.0.0
 */
public interface SchedulingMapper extends BaseMapper<Scheduling,String>{

	//根据岗位查询值班情况
	List<Scheduling> selectByPosition(Integer position);

	//根据班次查询值班情况
	List<Scheduling> selectByShiftId(String shiftId);

	//查询所有值班
	List<Map<String, Object>> selectSchedulings();
	
	//根据值班人查询值班
	List<Map<String, Object>> selectSchedulingByDutyMan(String dutyMan);
	
	List<Map<String, Object>> select(Map<String, Object> map);
}