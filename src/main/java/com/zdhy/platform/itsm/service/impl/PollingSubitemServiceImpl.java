package com.zdhy.platform.itsm.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.dao.PollingSubitemMapper;
import com.zdhy.platform.itsm.entity.PollingSubitem;
import com.zdhy.platform.itsm.service.IPollingSubitemService;

/**
 * 功能:巡检项目子项业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:55:58
 * @version v1.0.0
 */
@Service("pollingSubitemService")
@Transactional
public class PollingSubitemServiceImpl extends BaseServiceImpl<PollingSubitem, String> implements IPollingSubitemService{

	@Autowired
	private PollingSubitemMapper pollingSubitemMapper;
	
/*	@Override
	public PageView query(PageView pageView, PollingSubitem pollingSubitem) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("pollingSubitem", pollingSubitem);
		List<PollingSubitem> list = pollingSubitemMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(PollingSubitem pollingSubitem) throws Exception {
		return pollingSubitemMapper.insert(pollingSubitem);
	}

	@Override
	public int insertSelective(PollingSubitem pollingSubitem) throws Exception {
		return pollingSubitemMapper.insertSelective(pollingSubitem);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return pollingSubitemMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		pollingSubitemMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PollingSubitem pollingSubitem) throws Exception {
		return pollingSubitemMapper.updateByPrimaryKeySelective(pollingSubitem);
	}

	@Override
	public int updateByPrimaryKey(PollingSubitem pollingSubitem) throws Exception {
		return pollingSubitemMapper.updateByPrimaryKey(pollingSubitem);
	}

	@Override
	public PollingSubitem selectByPrimaryKey(String id) {
		return pollingSubitemMapper.selectByPrimaryKey(id);
	}

	@Override
	public PollingSubitem selectByName(String name) {
		return pollingSubitemMapper.selectByName(name);
	}

	@Override
	public List<PollingSubitem> selectAll() {
		return pollingSubitemMapper.selectAll();
	}

	@Override
	public PollingSubitem isExist(PollingSubitem pollingSubitem) {
		return pollingSubitemMapper.isExist(pollingSubitem);
	}

	@Override
	public List<PollingSubitem> queryAll(PollingSubitem pollingSubitem) {
		return pollingSubitemMapper.queryAll(pollingSubitem);
	}

	@Override
	public PollingSubitem selectByPrimaryKeyCascade(String id) {
		return pollingSubitemMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<PollingSubitem> queryByPage(int pageIndex, int pageSize) {
		return pollingSubitemMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return pollingSubitemMapper.queryPageTotal();
	}*/

	@Override
	public int insert(PollingSubitem pollingSubitem,String projectId) throws Exception {
		pollingSubitem.setProjectId(projectId);
		return pollingSubitemMapper.insert(pollingSubitem);
	}
	
	//删除巡检项目时删除关联的巡检子项
	@Override
	public int deleteSubitemsByProjectId(String projectId) {
		return pollingSubitemMapper.deleteByProjectId(projectId);
	}

	//批删
	@Override
	public int deleteSubitemsByIds(String ids) {
		if(StringUtils.isBlank(ids)){
			return -1;
		}
		String[] idArray = new String[]{};
		if(StringUtils.contains(ids, ",")){
			idArray = ids.split(",");
		}else{
			idArray = new String[]{ids};
		}
		try {
			return pollingSubitemMapper.deleteByIds(idArray);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "批删出现错误，ids[%s]", ids);
		}
		return 0;
	}

	//批删巡检模板时，批删巡检子项
	@Override
	public int deleteByTemplateIds(String[] idArray) {
		return pollingSubitemMapper.deleteByTemplateIds(idArray);
	}

	//批删巡检项目时，批删巡检子项
	@Override
	public void deleteByProjectIds(String[] idArray) {
		pollingSubitemMapper.deleteByProjectIds(idArray);
	}
	
	@Override
	public BaseMapper<PollingSubitem, String> getDao() {
		return pollingSubitemMapper;
	}
	
}

