package com.zdhy.platform.itsm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 功能: 
 * Menu.java
 * 创建人： 吴心宽
 * 时间： 2016年11月21日-下午6:19:47
 * @version v1.0.0
 */
public class Menu {

	private String id;
	private String name;
	private String level;
	private String pid;
	private List<Menu> menuChild = new ArrayList<Menu>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public List<Menu> getMenuChild() {
		return menuChild;
	}
	public void setMenuChild(List<Menu> menuChild) {
		this.menuChild = menuChild;
	}
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}