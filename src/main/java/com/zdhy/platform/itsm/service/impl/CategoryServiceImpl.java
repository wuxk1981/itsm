package com.zdhy.platform.itsm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.CategoryMapper;
import com.zdhy.platform.itsm.entity.Category;
import com.zdhy.platform.itsm.entity.dto.TreeJson;
import com.zdhy.platform.itsm.service.ICategoryService;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<Category, String>
		implements ICategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<TreeJson> getCategoryInfo() {
		List<TreeJson> treeList = new ArrayList<TreeJson>();
		List<Category> list = categoryMapper.selectAll();
		for (Category category : list) {
			TreeJson treeJson = new TreeJson();
			treeJson.setId(category.getId());
			treeJson.setText(category.getName());
			String parentId = category.getParentId();
			if (null != parentId) {
				treeJson.setPid(parentId);
			}
			treeList.add(treeJson);
		}
		treeList = TreeJson.formatTree(treeList);
		return treeList;
	}

	@Override
	public BaseMapper<Category, String> getDao() {
		return categoryMapper;
	}

}