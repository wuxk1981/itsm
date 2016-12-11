package com.zdhy.platform.itsm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.PollingObjectPlanMapper;
import com.zdhy.platform.itsm.entity.PollingObjectPlan;
import com.zdhy.platform.itsm.service.IPollingObjectPlanService;

/**
 * 功能:巡检对象与计划关联业务实现 创建人： 袁乐乐 时间： 2016年11月16日-下午6:20:58
 * 
 * @version v1.0.0
 */
@Service("pollingObjectPlanService")
@Transactional
public class PollingObjectPlanServiceImpl extends BaseServiceImpl<PollingObjectPlan, String> implements IPollingObjectPlanService {

	@Autowired
	private PollingObjectPlanMapper pollingObjectPlanMapper;

	@Override
	public BaseMapper<PollingObjectPlan, String> getDao() {
		return pollingObjectPlanMapper;
	}

	//巡检对象插入之后，插入一条次记录，维护巡检对象与巡检计划的关系
	@Override
	public int insert(String planId, String objectId) throws Exception {
		PollingObjectPlan pollingObjectPlan = new PollingObjectPlan();
		pollingObjectPlan.setObjectId(objectId);
		pollingObjectPlan.setPlanId(planId);
		return pollingObjectPlanMapper.insert(pollingObjectPlan);
	}
	
/*	@Override
	public PageView query(PageView pageView, PollingObjectPlan pollingObjectPlan) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("pollingObjectPlan", pollingObjectPlan);
		List<PollingObjectPlan> list = pollingObjectPlanMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(PollingObjectPlan pollingObjectPlan) throws Exception {
		return pollingObjectPlanMapper.insert(pollingObjectPlan);
	}

	@Override
	public int insertSelective(PollingObjectPlan pollingObjectPlan) throws Exception {
		return pollingObjectPlanMapper.insertSelective(pollingObjectPlan);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return pollingObjectPlanMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		pollingObjectPlanMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PollingObjectPlan pollingObjectPlan) throws Exception {
		return pollingObjectPlanMapper.updateByPrimaryKeySelective(pollingObjectPlan);
	}

	@Override
	public int updateByPrimaryKey(PollingObjectPlan pollingObjectPlan) throws Exception {
		return pollingObjectPlanMapper.updateByPrimaryKey(pollingObjectPlan);
	}

	@Override
	public PollingObjectPlan selectByPrimaryKey(String id) {
		return pollingObjectPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public PollingObjectPlan selectByName(String name) {
		return pollingObjectPlanMapper.selectByName(name);
	}

	@Override
	public List<PollingObjectPlan> selectAll() {
		return pollingObjectPlanMapper.selectAll();
	}

	@Override
	public PollingObjectPlan isExist(PollingObjectPlan pollingObjectPlan) {
		return pollingObjectPlanMapper.isExist(pollingObjectPlan);
	}

	@Override
	public List<PollingObjectPlan> queryAll(PollingObjectPlan pollingObjectPlan) {
		return pollingObjectPlanMapper.queryAll(pollingObjectPlan);
	}

	@Override
	public PollingObjectPlan selectByPrimaryKeyCascade(String id) {
		return pollingObjectPlanMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<PollingObjectPlan> queryByPage(int pageIndex, int pageSize) {
		return pollingObjectPlanMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return pollingObjectPlanMapper.queryPageTotal();
	}*/
	
}
