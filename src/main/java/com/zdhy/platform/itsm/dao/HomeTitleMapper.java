package com.zdhy.platform.itsm.dao;


import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.HomeContent;
import com.zdhy.platform.itsm.entity.HomeTitle;

public interface HomeTitleMapper extends BaseMapper<HomeTitle,String>{
	//根据标题id查询内容
	List<HomeContent> selectContentListByTitleId(String hpsId);
	
	//根据标题查找前十条内容
	List<HomeContent> selectTopTenContentListByTitleId(String hpsId);
}