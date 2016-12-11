package com.zdhy.platform.itsm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.DicMapper;
import com.zdhy.platform.itsm.entity.Dic;
import com.zdhy.platform.itsm.service.IDicService;

@Transactional
@Service("dicService")
public class DicServiceImpl extends BaseServiceImpl<Dic, String> implements
		IDicService {
	@Autowired
	private DicMapper dicMapper;

	@Override
	public BaseMapper<Dic, String> getDao() {
		return dicMapper;
	}

}
