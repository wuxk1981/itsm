package com.zdhy.platform.itsm.service;

import java.util.Map;

import com.zdhy.platform.itsm.core.base.BaseService;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.persistence.Page;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.entity.Person;

public interface IPersonService extends BaseService<Person,String> {
	Map<String, Object> deletePersonByIds(String ids);
	PageView findPersonByMap(Map<String, Object> paramMap);
	Pagination<Person> findPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
	Person get(String id);
	Page<Person> findPage(Page<Person> page, Person person);
}