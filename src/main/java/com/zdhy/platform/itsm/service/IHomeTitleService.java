package com.zdhy.platform.itsm.service;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.entity.HomeContent;
import com.zdhy.platform.itsm.entity.HomeTitle;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月8日-下午7:56:37
 * @version v1.0.0
 */
public interface IHomeTitleService extends BaseService<HomeTitle,String>{
	
	//根据标题查找前十条内容
	List<HomeContent> listTopTenContentsByTitleId(String hpsId);
	
	/*
	 * 级联查询
	 * 根据标题id,查询得到一条标题,及与该标题级联的内容
	 */
	HomeTitle findTitleByPKCascade(String titleId);
}

