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
import com.zdhy.platform.itsm.dao.ChangeMapper;
import com.zdhy.platform.itsm.entity.Change;
import com.zdhy.platform.itsm.service.IChangeService;

/**
 * 功能:换班业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午11:33:11
 * @version v1.0.0
 */
@Service("changeService")
@Transactional
public class ChangeServiceImpl extends BaseServiceImpl<Change, String>  implements IChangeService{

	@Autowired
	private ChangeMapper changeMapper;

	//值班管理界面查询所有
	@Override
	public PageView findByMap(Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(paramMap.get("staff")!=null){
			String staff = (String) paramMap.get("staff");
			map.put("staff", staff);
		}
		if(paramMap.get("changeShift")!=null){
			String changeShift = (String) paramMap.get("changeShift");
			map.put("changeShift", changeShift);
		}
		if(paramMap.get("beginDate")!=null){
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if(paramMap.get("endDate")!=null){
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<Change> list = changeMapper.query(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}
	
	//个人界面查询自己的
	@Override
	public PageView findMyChange(String staff,Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staff", staff);
		if(paramMap.get("changeShift")!=null){
			String changeShift = (String) paramMap.get("changeShift");
			map.put("changeShift", changeShift);
		}
		if(paramMap.get("beginDate")!=null){
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if(paramMap.get("endDate")!=null){
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<Change> list = changeMapper.queryMyChange(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public BaseMapper<Change, String> getDao() {
		return changeMapper;
	}
	
}

