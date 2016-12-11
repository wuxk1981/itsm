package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 巡检模板实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-上午11:36:56
 * @version v1.0.0
 */
public class PollingTemplate implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2576153609634209310L;

	private String id;

    //模板名称
    private String name;

    //模板类型
    private Integer type;

    //模板描述
    private String description;

    private List<PollingProject> pollingProjects= new ArrayList<PollingProject>();
    
    private List<PollingObject> pollingObjects= new ArrayList<PollingObject>();
    
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public List<PollingProject> getPollingProjects() {
		return pollingProjects;
	}

	public void setPollingProjects(List<PollingProject> pollingProjects) {
		this.pollingProjects = pollingProjects;
	}

	public List<PollingObject> getPollingObjects() {
		return pollingObjects;
	}

	public void setPollingObjects(List<PollingObject> pollingObjects) {
		this.pollingObjects = pollingObjects;
	}
}