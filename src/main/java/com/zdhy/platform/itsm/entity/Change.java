package com.zdhy.platform.itsm.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;
/**
 * 换班表实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午4:06:56
 * @version v1.0.0
 */
public class Change {
    private String id;

    //原值班人
    private String oldStaff;

    //原班次
    private String oldShift;

    //原值班日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
    private Date oldDutyDate;

    //换班原因
    private String changeReason;

    //换班人
    private String changeStaff;

    //换班班次
    private String changeShift;

    //换班日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date changeDate;

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

    public String getOldShift() {
        return oldShift;
    }

    public void setOldShift(String oldShift) {
        this.oldShift = oldShift == null ? null : oldShift.trim();
    }

    public Date getOldDutyDate() {
        return oldDutyDate;
    }

    public void setOldDutyDate(Date oldDutyDate) {
        this.oldDutyDate = oldDutyDate;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason == null ? null : changeReason.trim();
    }

    public String getChangeStaff() {
        return changeStaff;
    }

    public void setChangeStaff(String changeStaff) {
        this.changeStaff = changeStaff == null ? null : changeStaff.trim();
    }

    public String getChangeShift() {
        return changeShift;
    }

    public void setChangeShift(String changeShift) {
        this.changeShift = changeShift == null ? null : changeShift.trim();
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}