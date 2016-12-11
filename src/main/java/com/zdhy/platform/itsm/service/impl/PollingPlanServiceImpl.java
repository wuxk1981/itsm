package com.zdhy.platform.itsm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.core.utils.StringUtils;
import com.zdhy.platform.itsm.dao.DispatchingPlanMapper;
import com.zdhy.platform.itsm.dao.PollingObjectPlanMapper;
import com.zdhy.platform.itsm.dao.PollingPlanMapper;
import com.zdhy.platform.itsm.dao.PollingTaskMapper;
import com.zdhy.platform.itsm.entity.PollingPlan;
import com.zdhy.platform.itsm.entity.PollingTask;
import com.zdhy.platform.itsm.service.IPollingPlanService;
import com.zdhy.platform.itsm.service.ServiceException;

/**
 * 功能:巡检计划业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:48:58
 * @version v1.0.0
 */
@Service("pollingPlanService")
@Transactional
public class PollingPlanServiceImpl extends BaseServiceImpl<PollingPlan, String> implements IPollingPlanService{

	@Autowired
	private PollingPlanMapper pollingPlanMapper;
	@Autowired
	private DispatchingPlanMapper dispatchingPlanMapper;
	@Autowired
	private PollingObjectPlanMapper objectPlanMapper;
	@Autowired
	private PollingTaskMapper pollingTaskMapper;
	
	@Override
	public PageView query(PageView pageView, PollingPlan pollingPlan) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("pollingPlan", pollingPlan);
		List<Map<String, Object>> list = pollingPlanMapper.queryByPage(map);
		pageView.setRecords(list);
		return pageView;
	}
/*
	@Override
	public int insert(PollingPlan pollingPlan) throws Exception {
		return pollingPlanMapper.insert(pollingPlan);
	}

	@Override
	public int insertSelective(PollingPlan pollingPlan) throws Exception {
		return pollingPlanMapper.insertSelective(pollingPlan);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return pollingPlanMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		pollingPlanMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PollingPlan pollingPlan) throws Exception {
		return pollingPlanMapper.updateByPrimaryKeySelective(pollingPlan);
	}

	@Override
	public int updateByPrimaryKey(PollingPlan pollingPlan) throws Exception {
		return pollingPlanMapper.updateByPrimaryKey(pollingPlan);
	}

	@Override
	public PollingPlan selectByPrimaryKey(String id) {
		return pollingPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public PollingPlan selectByName(String name) {
		return pollingPlanMapper.selectByName(name);
	}

	@Override
	public List<PollingPlan> selectAll() {
		return pollingPlanMapper.selectAll();
	}

	@Override
	public PollingPlan isExist(PollingPlan pollingPlan) {
		return pollingPlanMapper.isExist(pollingPlan);
	}

	@Override
	public List<PollingPlan> queryAll(PollingPlan pollingPlan) {
		return pollingPlanMapper.queryAll(pollingPlan);
	}

	@Override
	public PollingPlan selectByPrimaryKeyCascade(String id) {
		return pollingPlanMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<PollingPlan> queryByPage(int pageIndex, int pageSize) {
		return pollingPlanMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return pollingPlanMapper.queryPageTotal();
	}*/
	

	@Override
	public int insert(PollingPlan pollingPlan) {
		String name = pollingPlan.getName();
		//校验该计划名称是否存在
		PollingPlan plan = pollingPlanMapper.selectByName(name);
		if(plan != null){
			throw new ServiceException("模板已经存在");
		}
		try {
			//巡检计划添加之后，默认不启动
			pollingPlan.setStatus(0);
			return pollingPlanMapper.insert(pollingPlan);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "插入出现错误", pollingPlan);
		}
		return 0;
	}
	
	//根据巡检计划id查询巡检对象及模板
	@Override
	public List<Map<String, String>> findTemplateAndObject(String id){
		if(StringUtils.isBlank(id)){
			throw new ServiceException("巡检计划id不存在");
		}
		return pollingPlanMapper.selectTemplateAndObject(id);
	}
	//根据巡检计划查询调度计划
	@Override
	public PollingPlan findDispatchingPlan(String pollPlanId) {
		if(StringUtils.isBlank(pollPlanId)){
			throw new ServiceException("巡检计划id不存在");
		}
		return pollingPlanMapper.findByPollPlanId(pollPlanId);
	}
	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		if(StringUtils.isBlank(id)){
			throw new ServiceException("巡检计划id不存在");
		}
		//在巡检计划与巡检对象关联表中删除关联关系
		objectPlanMapper.deleteByPlanId(id);
		//删除该计划下的调度计划
		dispatchingPlanMapper.deleteByPollingPlanId(id);
		return pollingPlanMapper.deleteByPrimaryKey(id);
	}
	

	@Override
	public int updateByPrimaryKeySelective(PollingPlan pollingPlan) throws Exception {
		if(StringUtils.isBlank(pollingPlan)){
			throw new ServiceException("巡检计划不存在");
		}
		String name = pollingPlan.getName();
		//校验该计划名称是否存在
		PollingPlan plan = pollingPlanMapper.selectByName(name);
		if(plan != null){
			throw new ServiceException("模板已经存在");
		}
		return pollingPlanMapper.updateByPrimaryKeySelective(pollingPlan);
	}
	
	//巡检计划启动
	@Override
	public void startPollingPlan(String id){
		List<Map<String, String>> lists = pollingPlanMapper.selectTemplateAndObject(id);
		PollingPlan pollingPlan = pollingPlanMapper.findByPollPlanId(id);
		if(lists.size()>0 && pollingPlan.getDispatchingPlan()!=null){
			//有巡检对象和调度计划才能启动巡检计划
			String workerNames = pollingPlan.getWorkerNames();
			Date beginDate = pollingPlan.getPollingTime();
			PollingTask pollingTask = new PollingTask();
			pollingTask.setName(pollingPlan.getName());
			pollingTask.setPollingMan(workerNames);
			pollingTask.setPollingTime(beginDate);
			pollingTask.setStatus(0);
			try {
				pollingTaskMapper.insert(pollingTask);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//按照周期是天来算
			if(pollingPlan.getDispatchingPlan().getPeriodDay()>0){
				//选择是整点时刻巡检
				if(pollingPlan.getDispatchingPlan().getMoment()>0){
					pollingTask.setName(pollingPlan.getName());
					pollingTask.setPollingMan(workerNames);
					pollingTask.setStatus(0);
					for(int i = 0;i<Integer.MAX_VALUE;i++){
						beginDate.getDay();
					}
				}
			}
		}
	}
	/*//添加计划时，点击提交，校验该计划名称是否存在
	@Override
	public Map<String, Object> selectPlanByName(String name) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String resultMsg = "添加成功";
			if(StringUtils.isBlank(name)){
				resultMsg = "请输入名字";
			}else{
				PollingPlan pollingPlan = pollingPlanMapper.selectByName(name);
				if(!StringUtils.isBlank(pollingPlan)){
					resultMsg = "计划"+name+"已经存在";
				}
			}
			resultMap.put("status", 200);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "系统异常!");
		}
		return resultMap;
	}*/

	@Override
	public BaseMapper<PollingPlan, String> getDao() {
		return pollingPlanMapper;
	}

}

