package com.zdhy.platform.itsm.service;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.Category;
import com.zdhy.platform.itsm.entity.dto.TreeJson;

public interface ICategoryService extends BaseService<Category,String> {
	public List<TreeJson> getCategoryInfo();
}
