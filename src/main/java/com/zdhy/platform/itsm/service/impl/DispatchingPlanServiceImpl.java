package com.zdhy.platform.itsm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.DispatchingPlanMapper;
import com.zdhy.platform.itsm.entity.DispatchingPlan;
import com.zdhy.platform.itsm.service.IDispatchingPlanService;
import com.zdhy.platform.itsm.service.IPollingPlanService;

/**
 * 功能:调度计划业务实现 
 * 创建人： 袁乐乐 
 * 时间： 2016年11月16日-上午10:05:58
 * 
 * @version v1.0.0
 */
@Service("dispatchingPlanService")
@Transactional
public class DispatchingPlanServiceImpl extends BaseServiceImpl<DispatchingPlan, String> 
   implements IDispatchingPlanService {

	@Autowired
	private DispatchingPlanMapper dispatchingPlanMapper;
	@Autowired
	private IPollingPlanService pollingPlanService;

	@Override
	public BaseMapper<DispatchingPlan, String> getDao() {
		return dispatchingPlanMapper;
	}

	@Override
	public int insert(DispatchingPlan dispatchingPlan,String planId) throws Exception {
		dispatchingPlan.setPlanId(planId);
		dispatchingPlanMapper.updatePollingPlan(dispatchingPlan.getBeginDate(), planId);
		return dispatchingPlanMapper.insert(dispatchingPlan);
	}
	
	@Override
	public int updateByPrimaryKeySelective(DispatchingPlan dispatchingPlan)
			throws Exception {
		dispatchingPlanMapper.updatePollingPlan(dispatchingPlan.getBeginDate(),
				dispatchingPlan.getPlanId());
		return dispatchingPlanMapper
				.updateByPrimaryKeySelective(dispatchingPlan);
	}
	/*@Override
	public PageView query(PageView pageView, DispatchingPlan dispatchingPlan) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("dispatchingPlan", dispatchingPlan);
		List<DispatchingPlan> list = dispatchingPlanMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(DispatchingPlan dispatchingPlan) throws Exception {
		return dispatchingPlanMapper.insert(dispatchingPlan);
	}

	@Override
	public int insertSelective(DispatchingPlan dispatchingPlan)
			throws Exception {
		return dispatchingPlanMapper.insertSelective(dispatchingPlan);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return dispatchingPlanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void logicalDelete(String id) throws Exception {
		dispatchingPlanMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DispatchingPlan dispatchingPlan)
			throws Exception {
		return dispatchingPlanMapper
				.updateByPrimaryKeySelective(dispatchingPlan);
	}

	@Override
	public int updateByPrimaryKey(DispatchingPlan dispatchingPlan)
			throws Exception {
		return dispatchingPlanMapper.updateByPrimaryKey(dispatchingPlan);
	}

	@Override
	public DispatchingPlan selectByPrimaryKey(String id) {
		return dispatchingPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public DispatchingPlan selectByName(String name) {
		return dispatchingPlanMapper.selectByName(name);
	}

	@Override
	public List<DispatchingPlan> selectAll() {
		return dispatchingPlanMapper.selectAll();
	}

	@Override
	public DispatchingPlan isExist(DispatchingPlan dispatchingPlan) {
		return dispatchingPlanMapper.isExist(dispatchingPlan);
	}

	@Override
	public List<DispatchingPlan> queryAll(DispatchingPlan dispatchingPlan) {
		return dispatchingPlanMapper.queryAll(dispatchingPlan);
	}

	@Override
	public DispatchingPlan selectByPrimaryKeyCascade(String id) {
		return dispatchingPlanMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<DispatchingPlan> queryByPage(int pageIndex, int pageSize) {
		return dispatchingPlanMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return dispatchingPlanMapper.queryPageTotal();
	}
*/
}
