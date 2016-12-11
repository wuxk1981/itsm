package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 工作台标题实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月4日-下午5:53:56
 * @version v1.0.0
 */
public class HomeTitle implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5433515070476897651L;

	private String id;

    //名称
    private String name;

    //模板路径
    private String modelPath;

    //排序
    private Integer priority;

    //描述
    private String des;
    
    private List<HomeContent> homeContents = new ArrayList<HomeContent>();

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



	public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
    
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public List<HomeContent> getHomeContents() {
		return homeContents;
	}

	public void setHomeContents(List<HomeContent> homeContents) {
		this.homeContents = homeContents;
	}

	public String getModelPath() {
		return modelPath;
	}

	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
}