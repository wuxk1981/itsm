package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Catalogue;
/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月4日-下午5:39:58
 * @version v1.0.0
 */
public interface CatalogueMapper extends BaseMapper<Catalogue,String>{

	List<Catalogue> findCatalogueByMap(Catalogue catalogue);
	
    
}