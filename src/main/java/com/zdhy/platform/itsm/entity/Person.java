package com.zdhy.platform.itsm.entity;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/*import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.zdhy.itsm.common.utils.JsonDateSerializer;*/
import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 功能: perso实体类
 * Person.java
 * 创建人： 吴心宽
 * 时间： 2016年11月4日-上午11:58:26
 * @version v1.0.0
 */
public class Person {
	private String id;
	private String name;
	private String address;
	private Integer age;
	private Date createTime;
	

	
	
	//页面时间查询属性
    private Date beginInDate;	// 开始时间
    private Date endInDate;	// 结束时间
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
	/**
	 * 时间格式化
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2014-2-17
	 * @return
	 */
	//@JsonSerialize(using=JsonDateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	public Date getEndInDate() {
		return endInDate;
	}

	public void setEndInDate(Date endInDate) {
		this.endInDate = endInDate;
	}

	public Date getBeginInDate() {
		return beginInDate;
	}

	public void setBeginInDate(Date beginInDate) {
		this.beginInDate = beginInDate;
	}




}