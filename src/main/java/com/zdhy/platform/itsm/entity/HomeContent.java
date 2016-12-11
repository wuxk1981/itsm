package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 工作台内容实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月4日-下午5:26:56
 * @version v1.0.0
 */
public class HomeContent implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2022132642123892698L;

	private String id;

    //标题Id
    private String hpsId;

    //名称
    private String name;

    //数据接口
    private String url;

    //排序
    private Integer priority;

    //描述
    private String des;
    
    private HomeTitle homeTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHpsId() {
        return hpsId;
    }

    public void setHpsId(String hpsId) {
        this.hpsId = hpsId == null ? null : hpsId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
    
	@Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}

	public HomeTitle getHomeTitle() {
		return homeTitle;
	}

	public void setHomeTitle(HomeTitle homeTitle) {
		this.homeTitle = homeTitle;
	}
    
}