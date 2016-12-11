package com.zdhy.platform.itsm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.common.Pagger;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.dao.HomeContentMapper;
import com.zdhy.platform.itsm.entity.HomeContent;
import com.zdhy.platform.itsm.service.IHomeContentService;

/**
 * 功能: 
 * HomeContentServiceImpl.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月8日-下午6:46:23
 * 
 * @version v1.0.0
 */
@Service
@Transactional
public class HomeContentServiceImpl extends
		BaseServiceImpl<HomeContent, String> implements IHomeContentService {

	@Autowired
	private HomeContentMapper homeContentMapper;

	@Override
	public BaseMapper<HomeContent, String> getDao() {
		return homeContentMapper;
	}

/*	@Override
	public PageView query(PageView pageView, HomeContent homeContent) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("homeContent", homeContent);
		List<HomeContent> list = homeContentMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(HomeContent homeContent) throws Exception {
		return homeContentMapper.insert(homeContent);
	}

	@Override
	public int insertSelective(HomeContent homeContent) throws Exception {
		return homeContentMapper.insertSelective(homeContent);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return homeContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void logicalDelete(String id) throws Exception {
		homeContentMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(HomeContent homeContent)
			throws Exception {
		return homeContentMapper.updateByPrimaryKeySelective(homeContent);
	}

	@Override
	public int updateByPrimaryKey(HomeContent homeContent) throws Exception {
		return homeContentMapper.updateByPrimaryKey(homeContent);
	}

	@Override
	public HomeContent selectByPrimaryKey(String id) {
		return homeContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public HomeContent selectByName(String name) {
		return homeContentMapper.selectByName(name);
	}

	@Override
	public List<HomeContent> selectAll() {
		return homeContentMapper.selectAll();
	}

	@Override
	public HomeContent isExist(HomeContent homeContent) {
		return homeContentMapper.isExist(homeContent);
	}

	@Override
	public List<HomeContent> queryAll(HomeContent homeContent) {
		return homeContentMapper.queryAll(homeContent);
	}

	@Override
	public HomeContent selectByPrimaryKeyCascade(String id) {
		return homeContentMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<HomeContent> queryByPage(int pageIndex, int pageSize) {
		return homeContentMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return homeContentMapper.queryPageTotal();
	}*/

}
