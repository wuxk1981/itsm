package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.entity.Person;


/**
 * 功能: PersonMapper接口
 * PersonMapper.java
 * 创建人： 吴心宽
 * 时间： 2016年11月4日-上午11:58:26
 * @version v1.0.0
 */
public interface PersonMapper extends BaseMapper<Person,String> {

	List<Person> findPersonByMap(Person person);
	List<Person> findList(Person person);
}