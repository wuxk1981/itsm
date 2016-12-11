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
import com.zdhy.platform.itsm.dao.InsteadMapper;
import com.zdhy.platform.itsm.entity.Instead;
import com.zdhy.platform.itsm.service.IInsteadService;

/**
 * 功能:替班业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午11:47:11
 * @version v1.0.0
 */
@Service("insteadService")
@Transactional
public class InsteadServiceImpl extends BaseServiceImpl<Instead, String> implements IInsteadService{

	@Autowired
	private InsteadMapper insteadMapper;

/*	@Override
	public PageView query(PageView pageView, Instead instead) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("Instead", instead);
		List<Instead> list = insteadMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}
	
	@Override
	public int insert(Instead instead) throws Exception {
		return insteadMapper.insert(instead);
	}

	@Override
	public int insertSelective(Instead instead) throws Exception {
		return insteadMapper.insertSelective(instead);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return insteadMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		insteadMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Instead instead) throws Exception {
		return insteadMapper.updateByPrimaryKeySelective(instead);
	}

	@Override
	public int updateByPrimaryKey(Instead instead) throws Exception {
		return insteadMapper.updateByPrimaryKey(instead);
	}

	@Override
	public Instead selectByPrimaryKey(String id) {
		return insteadMapper.selectByPrimaryKey(id);
	}

	@Override
	public Instead selectByName(String name) {
		return insteadMapper.selectByName(name);
	}

	@Override
	public List<Instead> selectAll() {
		return insteadMapper.selectAll();
	}

	@Override
	public Instead isExist(Instead instead) {
		return insteadMapper.isExist(instead);
	}

	@Override
	public List<Instead> queryAll(Instead instead) {
		return insteadMapper.queryAll(instead);
	}

	@Override
	public Instead selectByPrimaryKeyCascade(String id) {
		return insteadMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<Instead> queryByPage(int pageIndex, int pageSize) {
		return insteadMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return insteadMapper.queryPageTotal();
	}
*/
	//值班管理查询所有的
	@Override
	public PageView findByMap(Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(paramMap.get("staff")!=null){
			String staff = (String) paramMap.get("staff");
			map.put("staff", staff);
		}
		if(paramMap.get("insteadShift")!=null){
			String insteadShift = (String) paramMap.get("insteadShift");
			map.put("insteadShift", insteadShift);
		}
		if(paramMap.get("beginDate")!=null){
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if(paramMap.get("endDate")!=null){
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<Instead> list = insteadMapper.query(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	//个人查询自己的
	@Override
	public PageView findMyInstead(String staff,Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staff", staff);
		if(paramMap.get("insteadShift")!=null){
			String insteadShift = (String) paramMap.get("insteadShift");
			map.put("insteadShift", insteadShift);
		}
		if(paramMap.get("beginDate")!=null){
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if(paramMap.get("endDate")!=null){
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<Instead> list = insteadMapper.queryMyInstead(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public BaseMapper<Instead, String> getDao() {
		// TODO Auto-generated method stub
		return insteadMapper;
	}
	
}

