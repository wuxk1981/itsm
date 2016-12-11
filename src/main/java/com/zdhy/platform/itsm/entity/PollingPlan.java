package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 巡检计划实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午3:23:56
 * @version v1.0.0
 */
public class PollingPlan implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2754993125965899483L;

	private String id;

    //巡检名称
    private String name;

    //巡检人
    private String workerNames;

    //调度状态
    private Integer status;

    //巡检说明
    private String description;

    private Date pollingTime;
    //调度计划
    private DispatchingPlan dispatchingPlan;
    
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

    public String getWorkerNames() {
        return workerNames;
    }

    public void setWorkerNames(String workerNames) {
        this.workerNames = workerNames == null ? null : workerNames.trim();
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

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public DispatchingPlan getDispatchingPlan() {
		return dispatchingPlan;
	}

	public void setDispatchingPlan(DispatchingPlan dispatchingPlan) {
		this.dispatchingPlan = dispatchingPlan;
	}

	public Date getPollingTime() {
		return pollingTime;
	}

	public void setPollingTime(Date pollingTime) {
		this.pollingTime = pollingTime;
	}

}