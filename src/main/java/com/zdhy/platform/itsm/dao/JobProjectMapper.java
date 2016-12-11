package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.JobProject;

public interface JobProjectMapper extends BaseMapper<JobProject, String> {

	List<JobProject> findJobProjectByMap(JobProject jobProject);

}