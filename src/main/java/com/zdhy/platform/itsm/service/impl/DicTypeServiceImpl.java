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
import com.zdhy.platform.itsm.dao.DicTypeMapper;
import com.zdhy.platform.itsm.entity.Dic;
import com.zdhy.platform.itsm.entity.DicType;
import com.zdhy.platform.itsm.service.IDicTypeService;

@Transactional
@Service("dicTypeService")
public class DicTypeServiceImpl extends BaseServiceImpl<DicType, String> implements IDicTypeService {
	@Autowired
	private DicTypeMapper dicTypeMapper;

	@Override
	public BaseMapper<DicType, String> getDao() {
		return dicTypeMapper;
	}

/*	@Override
	public DicType isExist(DicType dicType) {
		return dicTypeMapper.isExist(dicType);
	}

	@Override
	public PageView query(PageView pageView, DicType dicType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", dicType);
		List<DicType> list = dicTypeMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(DicType dicType) throws Exception {
		return dicTypeMapper.insert(dicType);
	}

	@Override
	public int insertSelective(DicType dicType) throws Exception {
		return dicTypeMapper.insertSelective(dicType);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return dicTypeMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		dicTypeMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DicType dicType) throws Exception {
		return dicTypeMapper.updateByPrimaryKeySelective(dicType);
	}

	@Override
	public int updateByPrimaryKey(DicType dicType) throws Exception {
		return dicTypeMapper.updateByPrimaryKey(dicType);
	}

	@Override
	public DicType selectByPrimaryKey(String id) {
		return dicTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public DicType selectByName(String name) {
		return dicTypeMapper.selectByName(name);
	}

	@Override
	public List<DicType> selectAll() {
		return dicTypeMapper.selectAll();
	}

	@Override
	public List<DicType> queryAll(DicType dicType) {
		return dicTypeMapper.queryAll(dicType);
	}

	@Override
	public DicType selectByPrimaryKeyCascade(String id) {
		return dicTypeMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<DicType> queryByPage(int pageIndex, int pageSize) {
		return dicTypeMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return dicTypeMapper.queryPageTotal();
	}*/
	

}
