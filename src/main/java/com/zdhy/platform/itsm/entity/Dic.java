package com.zdhy.platform.itsm.entity;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 字典
 * @author lanyuan
 * Email：mmm333zzz520@163.com
 * date：2014-4-8
 */
@SuppressWarnings("serial")
public class Dic implements java.io.Serializable{
	
	private String id;
	private String dicTypeId;//类型ID
	private String dicKey;//key
	private String dicName;//名
	private String dicTypeName;//类型名
	private String dicTypeKey;//类型key
	private String description;//说明
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDicTypeId() {
		return dicTypeId;
	}
	public void setDicTypeId(String dicTypeId) {
		this.dicTypeId = dicTypeId;
	}
	public String getDicKey() {
		return dicKey;
	}
	public void setDicKey(String dicKey) {
		this.dicKey = dicKey;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDicTypeName() {
		return dicTypeName;
	}
	public void setDicTypeName(String dicTypeName) {
		this.dicTypeName = dicTypeName;
	}
	public String getDicTypeKey() {
		return dicTypeKey;
	}
	public void setDicTypeKey(String dicTypeKey) {
		this.dicTypeKey = dicTypeKey;
	}
	
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}	
}
