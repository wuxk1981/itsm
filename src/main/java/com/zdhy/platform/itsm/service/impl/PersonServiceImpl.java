package com.zdhy.platform.itsm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.persistence.Page;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.DateUtils;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.dao.PersonMapper;
import com.zdhy.platform.itsm.entity.Person;
import com.zdhy.platform.itsm.service.IPersonService;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person, String> 
		implements IPersonService {
	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	PersonMapper personMapper;

	@Override
	public Map<String, Object> deletePersonByIds(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int count=0;
			String resultMsg = "删除成功。";
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			c:for (String idx : idArray) {
				String id = new String(idx);
				if(new Long(1).equals(id)){
					resultMsg = "操作成功，But'系统管理员不能删除。";
					continue c;
				}else{
					count+=this.deleteByPrimaryKey(id);
				}
			}
			resultMap.put("status", 200);
			resultMap.put("count", count);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

	@Override
	public PageView findPersonByMap(Map<String, Object> paramMap) {
		Person person = new Person();
		Date beginInDate = DateUtils.parseDate(paramMap.get("beginInDate"));
/*		if (beginInDate == null){
			beginInDate = DateUtils.setDays(new Date(), 1);
			paramMap.put("beginInDate", DateUtils.formatDate(beginInDate, "yyyy-MM-dd"));
		}*/
		if(beginInDate != null){
			person.setBeginInDate(beginInDate);
		}
		Date endInDate = DateUtils.parseDate(paramMap.get("endInDate"));
		/*if (endInDate == null){
			endInDate = DateUtils.addDays(DateUtils.addMonths(beginInDate, 1), -1);
			paramMap.put("endInDate", DateUtils.formatDate(endInDate, "yyyy-MM-dd"));
		}*/
		if(endInDate != null){
			person.setEndInDate(endInDate);
		}
		
		String name = (String)paramMap.get("name");
		if (name != null && !("".equals(name))){
			person.setName(name);
		}
		String address = (String)paramMap.get("address");
		if (address != null && !("".equals(address))){
			person.setAddress(address);
		}
		
		List<Person> list = personMapper.findPersonByMap(person);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 分页方法 (简单条件 查询   OR)
	 */
	@Override
	public Pagination<Person> findPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public BaseMapper<Person, String> getDao() {
		return personMapper;
	}

	@Override
	public Person get(String id) {
		return personMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页 + 多条件模糊查询  
	 * 调试中
	 */
	@Override
	public Page<Person> findPage(Page<Person> page, Person person) {
		//person.setPage(page);
		page.setList(personMapper.findList(person));
		return page;
	}

}
