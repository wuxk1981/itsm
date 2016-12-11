package com.zdhy.platform.itsm.service;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.Module;

/**
 * 功能: 
 * IModuleService.java
 * 创建人： 吴心宽
 * 时间： 2016年11月9日-上午10:23:34
 * @version v1.0.0
 */
public interface IModuleService extends BaseService<Module,String> {


	Module add(Module module) throws Exception;
	Module delete(Integer id) throws Exception;	
	List<Module> findMainModule();
	List<Module> findSubModule(Module module);
	List<Module> treegrid(Integer id);
}
