package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.persistence.Page;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.JobProject;

public interface IJobProjectService extends BaseService<JobProject, String> {
	Map<String, Object> deleteJobProjectByIds(String ids);

	PageView findJobProjectByMap(Map<String, Object> paramMap);

	Pagination<JobProject> findPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);

	JobProject get(String id);

	Page<JobProject> findPage(Page<JobProject> page, JobProject jobProject);

}
