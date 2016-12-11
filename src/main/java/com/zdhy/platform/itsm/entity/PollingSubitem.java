package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 巡检子项实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-上午11:56:56
 * @version v1.0.0
 */
public class PollingSubitem implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7044317163145529795L;

	private String id;

    //巡检子项名称
    private String name;

    //是否自动取值
    private Integer isAuto;

    //输入方式
    private Integer inputType;

    //数据类型
    private Integer dataType;

    //最大长度
    private String maxLength;

    //默认值
    private String defaultValue;

    //排列顺序
    private Integer priority;

    //数据来源
    private String dataSource;

    //数据字典
    private String dataDictionary;

    //配置项库
    private String configItemRepo;

    //巡检项
    private String projectId;

    //巡检项描述
    private String description;

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

    public Integer getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Integer isAuto) {
        this.isAuto = isAuto;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength == null ? null : maxLength.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }

    public String getDataDictionary() {
        return dataDictionary;
    }

    public void setDataDictionary(String dataDictionary) {
        this.dataDictionary = dataDictionary == null ? null : dataDictionary.trim();
    }

    public String getConfigItemRepo() {
        return configItemRepo;
    }

    public void setConfigItemRepo(String configItemRepo) {
        this.configItemRepo = configItemRepo == null ? null : configItemRepo.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
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
}