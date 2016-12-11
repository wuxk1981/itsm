package com.zdhy.platform.itsm.entity.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;


/**
 * 功能: TreeGridCategory.java 创建人： 吴心宽 时间： 2016年11月21日-下午3:29:51
 * 
 * @version v1.0.0
 */
public class TreeGridCategory implements Serializable {
	private static final long serialVersionUID = 3880242917873205729L;
	private String id; /* ID */
	private String name; /* 名称 */
	private String path; /* 图标 */
	private String pid; /* 父级ID */
	private String level;
	private String state = "close"; /* 折叠状态 */
	private String lang;
	private String sort;
	private String status;
	private String leaf; /* 叶子节点标识：1：子节点 2：叶子节点 */

	Map<String,Object> params  = new HashMap<String,Object>();
	List<TreeGridCategory> children = new ArrayList<TreeGridCategory>();        /* 子集节点 */
	
	
	
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	
	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public List<TreeGridCategory> getChildren() {
		return children;
	}

	public void setChildren(List<TreeGridCategory> children) {
		this.children = children;
	}


	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

}
