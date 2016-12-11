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
import com.zdhy.platform.itsm.core.mybatis.BaseMybatisDao;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.dao.HomeTitleMapper;
import com.zdhy.platform.itsm.entity.HomeContent;
import com.zdhy.platform.itsm.entity.HomeTitle;
import com.zdhy.platform.itsm.service.IHomeTitleService;
import com.zdhy.platform.itsm.service.ServiceException;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月8日-下午7:57:46
 * @version v1.0.0
 */
@Service("homeTitleService")
@Transactional
public class HomeTitleServiceImpl extends BaseServiceImpl<HomeTitle, String> implements IHomeTitleService{

	@Autowired
	private HomeTitleMapper titleMapper;
	
/*	@Override
	public PageView query(PageView pageView, HomeTitle homeTitle) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("homeTitle", homeTitle);
		List<HomeTitle> list = titleMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(HomeTitle homeTitle) throws Exception {
		return titleMapper.insert(homeTitle);
	}

	@Override
	public int insertSelective(HomeTitle homeTitle) throws Exception {
		return titleMapper.insertSelective(homeTitle);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return titleMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		titleMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(HomeTitle homeTitle) throws Exception {
		return titleMapper.updateByPrimaryKeySelective(homeTitle);
	}

	@Override
	public int updateByPrimaryKey(HomeTitle homeTitle) throws Exception {
		return titleMapper.updateByPrimaryKey(homeTitle);
	}

	@Override
	public HomeTitle selectByPrimaryKey(String id) {
		return titleMapper.selectByPrimaryKey(id);
	}

	@Override
	public HomeTitle selectByName(String name) {
		return titleMapper.selectByName(name);
	}

	@Override
	public List<HomeTitle> selectAll() {
		return titleMapper.selectAll();
	}

	@Override
	public HomeTitle isExist(HomeTitle homeTitle) {
		return titleMapper.isExist(homeTitle);
	}

	@Override
	public List<HomeTitle> queryAll(HomeTitle homeTitle) {
		return titleMapper.queryAll(homeTitle);
	}

	@Override
	public HomeTitle selectByPrimaryKeyCascade(String id) {
		return titleMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<HomeTitle> queryByPage(int pageIndex, int pageSize) {
		return titleMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return titleMapper.queryPageTotal();
	}*/
	
	
	//根据标题查找前十条内容
	@Override
	public List<HomeContent> listTopTenContentsByTitleId(String hpsId) {
		if(hpsId == null || "".equals(hpsId)){
			throw new ServiceException("ID不能为空");
		}
		HomeTitle homeTitle = titleMapper.selectByPrimaryKey(hpsId);
		if(homeTitle == null){
			throw new ServiceException("没有该标题");
		}
		return titleMapper.selectTopTenContentListByTitleId(hpsId);
	}
	
	
	@Override
	public HomeTitle findTitleByPKCascade(String titleId) {
//		return titleMapper.selectByPrimaryKeyCascade(titleId);
		HomeTitle ht = titleMapper.selectByPrimaryKey(titleId);
		List<HomeContent> homeContents = titleMapper.selectContentListByTitleId(ht.getId());
		ht.setHomeContents(homeContents);
		return ht;
	}


	@Override
	public BaseMapper<HomeTitle, String> getDao() {
		return titleMapper;
	}


	
}

