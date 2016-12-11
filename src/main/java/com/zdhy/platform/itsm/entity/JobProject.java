package com.zdhy.platform.itsm.entity;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 作业项目实体 创建人： 袁乐乐 时间： 2016年11月4日-下午5:52:56
 * 
 * @version v1.0.0
 */
public class JobProject {

	private String id;

	// 作业名称
	private String name;

	// 说明
	private String illustrate;

	// 作业类别
	private Integer jobStyle;

	// 主要负责方
	private String mainDuty;

	// 辅助负责方
	private String assistDuty;

	// 发生周期及次数
	private String description;

	// 技术服务
	private String technologyId;
	// 技术服务 关联属性
	private Technology technology;

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

	public String getIllustrate() {
		return illustrate;
	}

	public void setIllustrate(String illustrate) {
		this.illustrate = illustrate == null ? null : illustrate.trim();
	}

	public Integer getJobStyle() {
		return jobStyle;
	}

	public void setJobStyle(Integer jobStyle) {
		this.jobStyle = jobStyle;
	}

	public String getMainDuty() {
		return mainDuty;
	}

	public void setMainDuty(String mainDuty) {
		this.mainDuty = mainDuty == null ? null : mainDuty.trim();
	}

	public String getAssistDuty() {
		return assistDuty;
	}

	public void setAssistDuty(String assistDuty) {
		this.assistDuty = assistDuty == null ? null : assistDuty.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(String technologyId) {
		this.technologyId = technologyId == null ? null : technologyId.trim();
	}

	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

}