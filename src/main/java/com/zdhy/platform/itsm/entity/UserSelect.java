package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;

/**
 * 用户选择实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月7日-下午2:36:56
 * @version v1.0.0
 */
public class UserSelect implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3825041304895027088L;

	private String id;

    //用户Id
    private String userId;

    //内容Id
    private String hpsId;

    //标题Id
    private String hpstId;

    //布局Id
    private String layoutId;

    //排序
    private Integer priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getHpsId() {
        return hpsId;
    }

    public void setHpsId(String hpsId) {
        this.hpsId = hpsId == null ? null : hpsId.trim();
    }

    public String getHpstId() {
        return hpstId;
    }

    public void setHpstId(String hpstId) {
        this.hpstId = hpstId == null ? null : hpstId.trim();
    }

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId == null ? null : layoutId.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}