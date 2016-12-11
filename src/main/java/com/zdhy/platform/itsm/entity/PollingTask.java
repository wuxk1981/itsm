package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 功能:巡检任务实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月28日-下午1:59:36
 * @version v1.0.0
 */
public class PollingTask implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -60161272839949650L;
	private String id;
	
	//任务编号
	private String number;
	
	//任务名称
	private String name;
	
	//巡检时间
	private Date pollingTime;
	
	//巡检人员
	private String pollingMan;
	
	//状态
	private Integer status;
	
	//报告提交时间
	private Date reportSubmitTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPollingTime() {
		return pollingTime;
	}

	public void setPollingTime(Date pollingTime) {
		this.pollingTime = pollingTime;
	}

	public String getPollingMan() {
		return pollingMan;
	}

	public void setPollingMan(String pollingMan) {
		this.pollingMan = pollingMan;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getReportSubmitTime() {
		return reportSubmitTime;
	}

	public void setReportSubmitTime(Date reportSubmitTime) {
		this.reportSubmitTime = reportSubmitTime;
	}
	
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

}

