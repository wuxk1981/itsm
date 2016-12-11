package com.zdhy.platform.itsm.entity;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

public class MenuModel {
	private Integer id;
	private Integer pid;
	private String url;
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public MenuModel(Integer id, Integer pid, String url, String text) {
		this.id = id;
		this.pid = pid;
		this.url = url;
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MenuModel() {
	}

	public MenuModel(Integer id, String url, String text) {
		this.id = id;
		this.url = url;
		this.text = text;
	}
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

}
