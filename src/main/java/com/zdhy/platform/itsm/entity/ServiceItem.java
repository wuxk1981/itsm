package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 业务项目实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月4日-下午6:53:56
 * @version v1.0.0
 */
public class ServiceItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -407583714126748901L;

	private String id;

	//服务项目名称
	private String name;
	
	//服务项目编号
	private String number;
	
	//服务类别
	private String serviceType;
	
	//服务流程
	private String serviceProcess;
	
	//服务说明
	private String description;
	
	//反馈设置(自动确认)
	private Integer feedbackSetAuto;
	
	//反馈设置(天)
	private Integer feedbackSetDay;
	
	//反馈设置(小时)
	private Integer feedbackSetHour; 
	
	//反馈设置(分钟)
	private Integer feedbackSetMin;
	
	//满意度
	private Integer feedbackSetSatisfaction;
	
	//运维经理
	private String sysUserId;
	
	//处理人员方式
	private Integer processerCategory;
	
	//支持人员
	private String supportUserName;
	
	//业务服务
	private String businessId;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getServiceProcess() {
        return serviceProcess;
    }

    public void setServiceProcess(String serviceProcess) {
        this.serviceProcess = serviceProcess == null ? null : serviceProcess.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getFeedbackSetAuto() {
        return feedbackSetAuto;
    }

    public void setFeedbackSetAuto(Integer feedbackSetAuto) {
        this.feedbackSetAuto = feedbackSetAuto;
    }

    public Integer getFeedbackSetDay() {
        return feedbackSetDay;
    }

    public void setFeedbackSetDay(Integer feedbackSetDay) {
        this.feedbackSetDay = feedbackSetDay;
    }

    public Integer getFeedbackSetHour() {
        return feedbackSetHour;
    }

    public void setFeedbackSetHour(Integer feedbackSetHour) {
        this.feedbackSetHour = feedbackSetHour;
    }

    public Integer getFeedbackSetMin() {
        return feedbackSetMin;
    }

    public void setFeedbackSetMin(Integer feedbackSetMin) {
        this.feedbackSetMin = feedbackSetMin;
    }

    public Integer getFeedbackSetSatisfaction() {
        return feedbackSetSatisfaction;
    }

    public void setFeedbackSetSatisfaction(Integer feedbackSetSatisfaction) {
        this.feedbackSetSatisfaction = feedbackSetSatisfaction;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId == null ? null : sysUserId.trim();
    }

    public Integer getProcesserCategory() {
        return processerCategory;
    }

    public void setProcesserCategory(Integer processerCategory) {
        this.processerCategory = processerCategory;
    }

    public String getSupportUserName() {
        return supportUserName;
    }

    public void setSupportUserName(String supportUserName) {
        this.supportUserName = supportUserName == null ? null : supportUserName.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}