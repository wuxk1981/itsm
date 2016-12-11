package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 班次表实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:23:56
 * @version v1.0.0
 */
public class Shift implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4707724566517971504L;

	private String id;

    //班次名称
    private String name;

    //颜色
    private String color;

    //开始时间
    private Date beginTime;

    //结束时间
    private Date endTime;

    //排班
    private List<Scheduling> schedulings = new ArrayList<Scheduling>();
    
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public List<Scheduling> getSchedulings() {
		return schedulings;
	}

	public void setSchedulings(List<Scheduling> schedulings) {
		this.schedulings = schedulings;
	}
}