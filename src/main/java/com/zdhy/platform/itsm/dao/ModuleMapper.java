package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Module;

public interface ModuleMapper extends BaseMapper<Module,String>{

	public List<Module> queryModules(Integer parentId);
	public Module selectByPrimaryKey(Integer id);
    
}