package com.zdhy.platform.itsm.entity;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;
/**
 * 服务目录实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月4日-下午4:49:56
 * @version v1.0.0
 */
public class Catalogue {

	private String id;
	
	//版本号
	private String version;
	
	//编号
	private String number;
	
	//名称
	private String name;
	
	//版本说明
	private String versionExplain;
	
	//创建日期
	private Date createDate;
	
	//发布日期
	private Date releaseDate;
	
	//发布人
	private String releaseUser;
	
	//版本状态
	private Integer state;
	
	//最后修改时间
	private Date lastModifyTime;
	
	//创建人
	private String createUser;
	
	//目录备份
	private String serviceCatalogueBak;
	
	private String uuid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getVersionExplain() {
        return versionExplain;
    }

    public void setVersionExplain(String versionExplain) {
        this.versionExplain = versionExplain == null ? null : versionExplain.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseUser() {
        return releaseUser;
    }

    public void setReleaseUser(String releaseUser) {
        this.releaseUser = releaseUser == null ? null : releaseUser.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getServiceCatalogueBak() {
        return serviceCatalogueBak;
    }

    public void setServiceCatalogueBak(String serviceCatalogueBak) {
        this.serviceCatalogueBak = serviceCatalogueBak == null ? null : serviceCatalogueBak.trim();
    }
    
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}