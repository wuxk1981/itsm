package com.zdhy.platform.itsm.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.common.Pagger;
import com.zdhy.platform.itsm.core.mybatis.BaseMybatisDao;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.dao.ModuleMapper;
import com.zdhy.platform.itsm.entity.Module;
import com.zdhy.platform.itsm.service.IModuleService;

/**
 * 功能: ModuleServiceImpl.java 创建人： 吴心宽 时间： 2016年11月9日-上午10:29:28
 * 
 * @version v1.0.0
 */
@Service(value = "moduleService")
@Transactional
public class ModuleServiceImpl extends BaseServiceImpl<Module, String>
		implements IModuleService {
	@Autowired
	private ModuleMapper moduleMapper;

	@Override
	public Module add(Module module) throws Exception {
		int intCont = moduleMapper.insert(module);
		if (intCont == 1) {
			return module;
		}

		return null;
	}

	@Override
	public Module delete(Integer id) throws Exception {
		Module module = moduleMapper.selectByPrimaryKey(String.valueOf(id));
		int i = moduleMapper.deleteByPrimaryKey(String.valueOf(id));
		if (i == 1) {
			return module;
		}
		return null;
	}

	@Override
	public List<Module> findMainModule() {
		return findSubModule(null);
	}

	@Override
	public List<Module> findSubModule(Module module) {
		List<Module> modules = null;
		if (null == module) {

			modules = moduleMapper.queryModules(0);
		} else {
			modules = moduleMapper.queryModules(module.getId());
		}
		return modules;
	}

	@Override
	public List<Module> treegrid(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseMapper<Module, String> getDao() {
		// TODO Auto-generated method stub
		return null;
	}
}
