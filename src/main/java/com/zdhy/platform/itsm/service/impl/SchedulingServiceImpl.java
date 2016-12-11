package com.zdhy.platform.itsm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.zdhy.platform.itsm.common.utils.DateUtils;
//import com.zdhy.platform.itsm.common.utils.LoggerUtils;
import com.zdhy.platform.itsm.core.utils.DateUtils;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.SchedulingMapper;
import com.zdhy.platform.itsm.entity.Scheduling;
import com.zdhy.platform.itsm.service.ISchedulingService;
import com.zdhy.platform.itsm.service.ServiceException;

/**
 * 功能:排班业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-上午11:15:04
 * @version v1.0.0
 */
@Service("schedulingService")
@Transactional
public class SchedulingServiceImpl extends BaseServiceImpl<Scheduling, String> implements ISchedulingService{
	
	@Autowired
	private SchedulingMapper schedulingMapper;

	//值班表管理首页加载值班
	@Override
	public List<Map<String,Object>> showSchedulings(Map<String, Object> paramMap){
		Map<String, Object> map = new HashMap<String, Object>();
		if(paramMap.get("dutyMan")!=null){
			String dutyMan = (String) paramMap.get("dutyMan");
			map.put("dutyMan", dutyMan);
		}
		if(paramMap.get("type") != null){
			//月
			if("1".equals(paramMap.get("type"))){
				int year = (int) paramMap.get("year");
				int month = (int) paramMap.get("month");
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,year);
				cal.set(Calendar.MONTH, month);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				cal.add(Calendar.DAY_OF_MONTH, -1);
				Date lastDate = cal.getTime();
				cal.set(Calendar.DAY_OF_MONTH, 1);
				Date firstDate = cal.getTime();
				map.put("beginDate", firstDate);
				map.put("endDate", lastDate);
			}
			//周
			if("2".equals(paramMap.get("type"))){
				int year = (int) paramMap.get("year");
				int week = (int) paramMap.get("month");
				Date beginDate = DateUtils.getFirstDayOfWeek(year, week);
				Date endDate = DateUtils.getLastDayOfWeek(year, week);
				map.put("beginDate", beginDate);
				map.put("endDate", endDate);
			}
			//日
			if("3".equals(paramMap.get("type"))){
				int year = (int) paramMap.get("year");
				int month = (int) paramMap.get("month");
				int day = (int) paramMap.get("day");
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,year);
				cal.set(Calendar.MONTH, month-1);
				cal.set(Calendar.DAY_OF_MONTH, day);
				Date date = cal.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date = sdf.parse(sdf.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				map.put("date", date);
			}
		}
		return schedulingMapper.select(map);
		
	}
	
	
	//员工点击我的值班表加载自己的值班
	@Override
	public List<Map<String,Object>> listSchedulingByDutyMan(String dutyMan){
		return schedulingMapper.selectSchedulingByDutyMan(dutyMan);
	}
	@Override
	public int insert(Scheduling scheduling)  {
		String shiftId = scheduling.getShiftId();
		Integer position = scheduling.getPosition();
		String dutyMan = scheduling.getDutyMan();
		List<Scheduling> lists = new ArrayList<Scheduling>();
		try {
			//必须先添加主岗，才能添加副岗
			if(position==0){
				//根据班次判断是否已经添加主岗
				lists = schedulingMapper.selectByShiftId(shiftId);
				//如果没有添加主岗，返回
				if(lists.size()==0){
					throw new ServiceException("必须先添加主岗，才能添加副岗");
				}
				//主岗已经添加,同班次人员不能重复
				for(Scheduling sh:lists){
					if(dutyMan.equals(sh.getDutyMan())){
						throw new ServiceException("同班次人员不能重复");
					}
				}
				//主岗已经添加，若是一个班次已经有三个岗位，则不允许继续添加
				if(lists.size()>2){
					throw new ServiceException("同班次最多不超过3人"); 
				}
			}
			
			if(position==1){
				//查看该班次
				lists = schedulingMapper.selectByShiftId(shiftId);
				//该班次还没开始添加,直接添加
				if(lists.size()>0){
					//该班次已经添加,判断同岗位主岗只能有一个人     
					lists = schedulingMapper.selectByPosition(position);
					if(lists.size()>0){
						throw new ServiceException("同岗位主岗只能有一个人 "); 
					}
				}
			}
			return schedulingMapper.insert(scheduling);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "插入出现错误", scheduling);
		}
		return 0;
	}
/*	@Override
	public PageView query(PageView pageView, Scheduling scheduling) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("scheduling", scheduling);
		List<Scheduling> list = schedulingMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(Scheduling scheduling) throws Exception {
		return schedulingMapper.insert(scheduling);
	}

	@Override
	public int insertSelective(Scheduling scheduling) throws Exception {
		return schedulingMapper.insertSelective(scheduling);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return schedulingMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		schedulingMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Scheduling scheduling) throws Exception {
		return schedulingMapper.updateByPrimaryKeySelective(scheduling);
	}

	@Override
	public int updateByPrimaryKey(Scheduling scheduling) throws Exception {
		return schedulingMapper.updateByPrimaryKey(scheduling);
	}

	@Override
	public Scheduling selectByPrimaryKey(String id) {
		return schedulingMapper.selectByPrimaryKey(id);
	}

	@Override
	public Scheduling selectByName(String name) {
		return schedulingMapper.selectByName(name);
	}

	@Override
	public List<Scheduling> selectAll() {
		return schedulingMapper.selectAll();
	}

	@Override
	public Scheduling isExist(Scheduling scheduling) {
		return schedulingMapper.isExist(scheduling);
	}

	@Override
	public List<Scheduling> queryAll(Scheduling scheduling) {
		return schedulingMapper.queryAll(scheduling);
	}

	@Override
	public Scheduling selectByPrimaryKeyCascade(String id) {
		return schedulingMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<Scheduling> queryByPage(int pageIndex, int pageSize) {
		return schedulingMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return schedulingMapper.queryPageTotal();
	}*/
	

	@Override
	public BaseMapper<Scheduling, String> getDao() {
		return schedulingMapper;
	}

}

