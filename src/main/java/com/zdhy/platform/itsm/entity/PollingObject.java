package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 巡检对象实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-上午11:53:56
 * @version v1.0.0
 */
public class PollingObject implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6346044338540912062L;

	private String id;

    //巡检模板
    private String templateId;

    //巡检名称
    private String name;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}