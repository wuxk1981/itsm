package com.zdhy.platform.itsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.dao.OrgMapper;
import com.zdhy.platform.itsm.entity.dto.TreeJson;
import com.zdhy.platform.itsm.service.IOrgService;

@Service("OrgService")
@Transactional
public class OrgServiceImpl implements IOrgService {

	@Autowired
	private OrgMapper orgMapper;

	@Override
	public List<TreeJson> getOrgInfo() {
		List<TreeJson> treeList = orgMapper.selectAll();
		treeList = TreeJson.formatTree(treeList);
		return treeList;
	}
}