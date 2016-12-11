package com.zdhy.platform.itsm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.DateUtils;
import com.zdhy.platform.itsm.dao.PollingTaskMapper;
import com.zdhy.platform.itsm.entity.PollingTask;
import com.zdhy.platform.itsm.service.IPollingTaskService;

/**
 * 功能:巡检任务业务实现类
 * 创建人： 袁乐乐
 * 时间： 2016年11月28日-下午3:11:53
 * @version v1.0.0
 */
@Service
@Transactional
public class PollingTaskImpl implements IPollingTaskService{

	@Autowired
	private PollingTaskMapper pollingTaskmapper;
	
	@Override
	public PageView findByMap(Map<String, Object> paramMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(paramMap.get("name")!=null){
			String name = (String) paramMap.get("name");
			map.put("name", name);
		}
		if(paramMap.get("pollingMan")!=null){
			String pollingMan = (String) paramMap.get("pollingMan");
			map.put("pollingMan", pollingMan);
		}
		if(paramMap.get("status")!=null){
			String status = (String) paramMap.get("status");
			map.put("status", status);
		}
		if(paramMap.get("beginDate")!=null){
			Date beginDate = DateUtils.parseDate(paramMap.get("beginDate"));
			map.put("beginDate", beginDate);
		}
		if(paramMap.get("endDate")!=null){
			Date endDate = DateUtils.parseDate(paramMap.get("endDate"));
			map.put("endDate", endDate);
		}
		List<PollingTask> list = pollingTaskmapper.query(map);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	//根据巡检人查询巡检任务
	@Override
	public List<Map<String, Object>> showMyTask(String pollingMan){
		return pollingTaskmapper.selectByPollingMan(pollingMan);
	}

}

