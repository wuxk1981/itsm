package com.zdhy.platform.itsm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.PollingObjectMapper;
import com.zdhy.platform.itsm.entity.PollingObject;
import com.zdhy.platform.itsm.service.IPollingObjectPlanService;
import com.zdhy.platform.itsm.service.IPollingObjectService;

/**
 * 功能:巡检对象业务实现 创建人： 袁乐乐 时间： 2016年11月16日-上午9:28:58
 * 
 * @version v1.0.0
 */
@Service("pollingObjectService")
@Transactional
public class PollingObjectServiceImpl extends BaseServiceImpl<PollingObject, String> implements IPollingObjectService {

	@Autowired
	private PollingObjectMapper pollingObjectMapper;
	@Autowired
	private IPollingObjectPlanService pollingObjectPlanService;

	@Override
	public BaseMapper<PollingObject, String> getDao() {
		return pollingObjectMapper;
	}

	@Override
	public int insert(PollingObject pollingObject,String templateId,String planId) throws Exception {
		pollingObject.setTemplateId(templateId);
		pollingObjectMapper.insert(pollingObject);
		//在巡检计划与对象关联里面插入一条数据
		pollingObjectPlanService.insert(planId, pollingObject.getId());
		return 1;
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		//在巡检计划与对象关联里面删除一条数据
		
		return pollingObjectMapper.deleteByPrimaryKey(id);
	}
/*	@Override
	public PageView query(PageView pageView, PollingObject pollingObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("pollingObject", pollingObject);
		List<PollingObject> list = pollingObjectMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(PollingObject pollingObject) throws Exception {
		return pollingObjectMapper.insert(pollingObject);
	}

	@Override
	public int insertSelective(PollingObject pollingObject) throws Exception {
		return pollingObjectMapper.insertSelective(pollingObject);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return pollingObjectMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		pollingObjectMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PollingObject pollingObject) throws Exception {
		return pollingObjectMapper.updateByPrimaryKeySelective(pollingObject);
	}

	@Override
	public int updateByPrimaryKey(PollingObject pollingObject) throws Exception {
		return pollingObjectMapper.updateByPrimaryKey(pollingObject);
	}

	@Override
	public PollingObject selectByPrimaryKey(String id) {
		return pollingObjectMapper.selectByPrimaryKey(id);
	}

	@Override
	public PollingObject selectByName(String name) {
		return pollingObjectMapper.selectByName(name);
	}

	@Override
	public List<PollingObject> selectAll() {
		return pollingObjectMapper.selectAll();
	}

	@Override
	public PollingObject isExist(PollingObject pollingObject) {
		return pollingObjectMapper.isExist(pollingObject);
	}

	@Override
	public List<PollingObject> queryAll(PollingObject pollingObject) {
		return pollingObjectMapper.queryAll(pollingObject);
	}

	@Override
	public PollingObject selectByPrimaryKeyCascade(String id) {
		return pollingObjectMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<PollingObject> queryByPage(int pageIndex, int pageSize) {
		return pollingObjectMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return pollingObjectMapper.queryPageTotal();
	}*/
	
}
