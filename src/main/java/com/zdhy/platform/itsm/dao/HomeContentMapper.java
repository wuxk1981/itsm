package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.HomeContent;

public interface HomeContentMapper extends BaseMapper<HomeContent,String>{
    
	//根据标题id查询内容
	List<HomeContent> selectContentListByTitleId(String hpsId);
	
}