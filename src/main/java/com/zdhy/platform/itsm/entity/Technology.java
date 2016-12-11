package com.zdhy.platform.itsm.entity;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;
/**
 * 技术服务实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月7日-上午11:26:56
 * @version v1.0.0
 */
public class Technology {

	private String id;
	//服务编码
	private String coding;
	
	//服务名称
	private String name;
	
	//服务期限开始
	private Date deadlineStart;
	
	//服务期限结束
	private Date deadlineEnd;
	
	//备注
	private String remark;
	
	//服务计量模式
	private String measure;
	
	//服务用户
	private String serviceUser;
	
	//服务对象
	private String serviceObject;
	
	//负责团队
	private String principalTeam;
	
	//服务负责人
	private String servicePrincipal;
	
	//附件
	private String jobSummaryAccessory;
	
	//服务作业概要
	private String jobSummaryDescribe;
	
	//作业项目
	private String jobProject;
	
	private String uuid;
	
	//服务分类
	private String categoryId;
	
	/*
	 * 关联属性
	 */
	private List<JobProject> jobProjects;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding == null ? null : coding.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDeadlineStart() {
        return deadlineStart;
    }

    public void setDeadlineStart(Date deadlineStart) {
        this.deadlineStart = deadlineStart;
    }

    public Date getDeadlineEnd() {
        return deadlineEnd;
    }

    public void setDeadlineEnd(Date deadlineEnd) {
        this.deadlineEnd = deadlineEnd;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    public String getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(String serviceUser) {
        this.serviceUser = serviceUser == null ? null : serviceUser.trim();
    }

    public String getServiceObject() {
        return serviceObject;
    }

    public void setServiceObject(String serviceObject) {
        this.serviceObject = serviceObject == null ? null : serviceObject.trim();
    }

    public String getPrincipalTeam() {
        return principalTeam;
    }

    public void setPrincipalTeam(String principalTeam) {
        this.principalTeam = principalTeam == null ? null : principalTeam.trim();
    }

    public String getJobSummaryAccessory() {
        return jobSummaryAccessory;
    }

    public void setJobSummaryAccessory(String jobSummaryAccessory) {
        this.jobSummaryAccessory = jobSummaryAccessory == null ? null : jobSummaryAccessory.trim();
    }

    public String getJobSummaryDescribe() {
        return jobSummaryDescribe;
    }

    public void setJobSummaryDescribe(String jobSummaryDescribe) {
        this.jobSummaryDescribe = jobSummaryDescribe == null ? null : jobSummaryDescribe.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }
    
    public String getServicePrincipal() {
        return servicePrincipal;
    }

    public void setServicePrincipal(String servicePrincipal) {
        this.servicePrincipal = servicePrincipal == null ? null : servicePrincipal.trim();
    }

    public String getJobProject() {
        return jobProject;
    }

    public void setJobProject(String jobProject) {
        this.jobProject = jobProject == null ? null : jobProject.trim();
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public List<JobProject> getJobProjects() {
		return jobProjects;
	}

	public void setJobProjects(List<JobProject> jobProjects) {
		this.jobProjects = jobProjects;
	}
    
}