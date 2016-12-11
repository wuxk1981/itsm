package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 巡检对象与计划关联实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-下午5:13:56
 * @version v1.0.0
 */
public class PollingObjectPlan implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1151341289217456634L;

	private String id;

    //巡检对象
    private String objectId;

    //巡检计划
    private String planId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}