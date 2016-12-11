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
import com.zdhy.platform.itsm.core.utils.DateUtils;
import com.zdhy.platform.itsm.dao.LogbookMapper;
import com.zdhy.platform.itsm.entity.Logbook;
import com.zdhy.platform.itsm.service.ILogbookService;

/**
 * 功能:值班日志业务实现 
 * 创建人： 袁乐乐 
 * 时间： 2016年11月16日-上午11:55:11
 * 
 * @version v1.0.0
 */
@Service("logbookService")
@Transactional
public class LogbookServiceImpl extends BaseServiceImpl<Logbook, String>
		implements ILogbookService {

	@Autowired
	private LogbookMapper logbookMapper;

	@Override
	public int insert(Logbook logbook) throws Exception {
		logbook.setCreateTime(new Date());
		return logbookMapper.insert(logbook);
	}
/*	@Override  
	public PageView query(PageView pageView, Logbook logbook) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("logbook", logbook);
		List<Logbook> list = logbookMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(Logbook logbook) throws Exception {
		return logbookMapper.insert(logbook);
	}

	@Override
	public int insertSelective(Logbook logbook) throws Exception {
		return logbookMapper.insertSelective(logbook);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return logbookMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void logicalDelete(String id) throws Exception {
		logbookMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Logbook logbook) throws Exception {
		return logbookMapper.updateByPrimaryKeySelective(logbook);
	}

	@Override
	public int updateByPrimaryKey(Logbook logbook) throws Exception {
		return logbookMapper.updateByPrimaryKey(logbook);
	}

	@Override
	public Logbook selectByPrimaryKey(String id) {
		return logbookMapper.selectByPrimaryKey(id);
	}

	@Override
	public Logbook selectByName(String name) {
		return logbookMapper.selectByName(name);
	}

	@Override
	public List<Logbook> selectAll() {
		return logbookMapper.selectAll();
	}

	@Override
	public Logbook isExist(Logbook logbook) {
		return logbookMapper.isExist(logbook);
	}

	@Override
	public List<Logbook> queryAll(Logbook logbook) {
		return logbookMapper.queryAll(logbook);
	}

	@Override
	public Logbook selectByPrimaryKeyCascade(String id) {
		return logbookMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<Logbook> queryByPage(int pageIndex, int pageSize) {
		return logbookMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return logbookMapper.queryPageTotal();
	}
*/
	@Override
	public PageView findByMap(Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (paramMap.get("staff") != null) {
			String staff = (String) paramMap.get("staff");
			map.put("staff", staff);
		}
		if (paramMap.get("shift") != null) {
			String shift = (String) paramMap.get("shift");
			map.put("shift", shift);
		}
		if (paramMap.get("beginDate") != null) {
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if (paramMap.get("endDate") != null) {
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<Logbook> list = logbookMapper.query(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}
	
	@Override
	public PageView findMyLogbook(String staff,Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staff", staff);
		if (paramMap.get("shift") != null) {
			String shift = (String) paramMap.get("shift");
			map.put("shift", shift);
		}
		if (paramMap.get("beginDate") != null) {
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if (paramMap.get("endDate") != null) {
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<Logbook> list = logbookMapper.queryMyLogbook(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public BaseMapper<Logbook, String> getDao() {
		return logbookMapper;
	}

}
