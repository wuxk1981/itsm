package com.zdhy.platform.itsm.entity;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 字典类型
 * @author lanyuan
 * Email：mmm333zzz520@163.com
 * date：2014-4-8
 */
@SuppressWarnings("serial")
public class DicType implements java.io.Serializable{
	
	private String id;
	private String dicTypeKey;//类型KEY
	private String dicTypeName;//类型名
	private String description;//说明
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDicTypeKey() {
		return dicTypeKey;
	}
	public void setDicTypeKey(String dicTypeKey) {
		this.dicTypeKey = dicTypeKey;
	}
	public String getDicTypeName() {
		return dicTypeName;
	}
	public void setDicTypeName(String dicTypeName) {
		this.dicTypeName = dicTypeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}
