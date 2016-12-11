package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;
/**
 * 替班表实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:16:56
 * @version v1.0.0
 */
public class Instead implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4867484126867702291L;

	private String id;

    //原值班人
    private String oldStaff;

    //替班人
    private String insteadStaff;

    //替班班次
    private String insteadShift;

    //替班日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date insteadDate;

    //替班原因
    private String insteadReason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOldStaff() {
        return oldStaff;
    }

    public void setOldStaff(String oldStaff) {
        this.oldStaff = oldStaff == null ? null : oldStaff.trim();
    }

    public String getInsteadStaff() {
        return insteadStaff;
    }

    public void setInsteadStaff(String insteadStaff) {
        this.insteadStaff = insteadStaff == null ? null : insteadStaff.trim();
    }

    public String getInsteadShift() {
        return insteadShift;
    }

    public void setInsteadShift(String insteadShift) {
        this.insteadShift = insteadShift == null ? null : insteadShift.trim();
    }

    public Date getInsteadDate() {
        return insteadDate;
    }

    public void setInsteadDate(Date insteadDate) {
        this.insteadDate = insteadDate;
    }

    public String getInsteadReason() {
        return insteadReason;
    }

    public void setInsteadReason(String insteadReason) {
        this.insteadReason = insteadReason == null ? null : insteadReason.trim();
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}