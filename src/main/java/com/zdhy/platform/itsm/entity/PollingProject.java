package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 巡检项目实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-上午11:33:56
 * @version v1.0.0
 */
public class PollingProject implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4727016907102860829L;

	private String id;

    //项目名称
    private String name;

    //显示顺序
    private Integer priority;

    //巡检模板
    private String templateId;

    //项目描述
    private String description;

    //巡检子项
    private List<PollingSubitem> pollingSubitems = new ArrayList<PollingSubitem>();
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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
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

	public List<PollingSubitem> getPollingSubitems() {
		return pollingSubitems;
	}

	public void setPollingSubitems(List<PollingSubitem> pollingSubitems) {
		this.pollingSubitems = pollingSubitems;
	}
}