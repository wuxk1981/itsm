package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 服务分类实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月4日-下午4:56:56
 * @version v1.0.0
 */
public class Category implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5022193022804261356L;

	private String id;

    //名称
    private String name;

    //父ID
    private String parentId;

    //状态
    private Integer status;

    //描述
    private String description;

    //服务目录
    private String catalogueId;
    
    private List<Category> children = new ArrayList<Category>();

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCatalogueId() {
        return catalogueId;
    }

    public void setCatalogueId(String catalogueId) {
        this.catalogueId = catalogueId == null ? null : catalogueId.trim();
    }

	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}
    
}