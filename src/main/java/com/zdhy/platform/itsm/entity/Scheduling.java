package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 值班表实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:28:56
 * @version v1.0.0
 */
public class Scheduling implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7768455457991793053L;

	private String id;

    //班次
    private String shiftId;

    //岗位      主岗1,副岗0
    private Integer position;  

    //值班员工id
    private String dutyManId;
    
    //值班员工
    private String dutyMan;
    
    //值班日期
    private Date dutyDate;
    
    //值班类型
    private Integer type;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId == null ? null : shiftId.trim();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public String getDutyMan() {
		return dutyMan;
	}

	public void setDutyMan(String dutyMan) {
		this.dutyMan = dutyMan;
	}

	public Date getDutyDate() {
		return dutyDate;
	}

	public void setDutyDate(Date dutyDate) {
		this.dutyDate = dutyDate;
	}

	public String getDutyManId() {
		return dutyManId;
	}

	public void setDutyManId(String dutyManId) {
		this.dutyManId = dutyManId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}