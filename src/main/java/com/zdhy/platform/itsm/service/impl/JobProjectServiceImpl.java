package com.zdhy.platform.itsm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.persistence.Page;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.dao.JobProjectMapper;
import com.zdhy.platform.itsm.entity.JobProject;
import com.zdhy.platform.itsm.service.IJobProjectService;

@Service
@Transactional(readOnly = true)
public class JobProjectServiceImpl extends BaseServiceImpl<JobProject, String> 
		implements IJobProjectService {
	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	JobProjectMapper jobProjectMapper;

	@Override
	public Map<String, Object> deleteJobProjectByIds(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int count=0;
			String resultMsg = "删除成功。";
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			c:for (String idx : idArray) {
				String id = new String(idx);
				if(new Long(1).equals(id)){
					resultMsg = "操作成功，But'系统管理员不能删除。";
					continue c;
				}else{
					count+=this.deleteByPrimaryKey(id);
				}
			}
			resultMap.put("status", 200);
			resultMap.put("count", count);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

	@Override
	public PageView findJobProjectByMap(Map<String, Object> paramMap) {
		JobProject JobProject = new JobProject();
		String name = (String)paramMap.get("name");
		if (name != null && !("".equals(name))){
			JobProject.setName(name);
		}
		
		List<JobProject> list = jobProjectMapper.findJobProjectByMap(JobProject);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 分页方法 (简单条件 查询   OR)
	 */
	@Override
	public Pagination<JobProject> findPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public BaseMapper<JobProject, String> getDao() {
		return jobProjectMapper;
	}

	@Override
	public JobProject get(String id) {
		return jobProjectMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页 + 多条件模糊查询  
	 * 调试中
	 */
	@Override
	public Page<JobProject> findPage(Page<JobProject> page, JobProject JobProject) {
		//JobProject.setPage(page);
		page.setList(jobProjectMapper.findList(JobProject));
		return page;
	}

}
