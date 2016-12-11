package com.zdhy.platform.itsm.entity;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.zdhy.platform.itsm.core.utils.JsonDateValueProcessor;
/**
 * 调度计划实体
 * 创建人： 袁乐乐
 * 时间： 2016年11月15日-下午3:13:56
 * @version v1.0.0
 */
public class DispatchingPlan implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5549443819432087057L;

	private String id;

    //开始时间
    private Date beginDate;

    //结束时间
    private Date endDate;

    //预计执行时长
    private Integer expectTimes;

    //巡检周期
    private Integer pollingPeriod;

    //每天
    private Integer periodDay;

    //每周
    private Integer periodWeekday;

    //每月
    private Integer periodMonth;

    //时刻选择
    private Integer moment;

    //自定义时刻
    private String momentValue;

    //起始时刻
    private String beginingTime;

    //每间隔
    private Integer inBetween;

    //是否提前
    private Integer isBefor;

    //时长
    private Integer time;

    //计时方式  1-天  2-小时  3-分钟
    private Integer timerMode;

    //提醒方式  1-界面消息  2-电子邮件   3-手机短信
    private Integer remindWay;

    //巡检计划
    private String planId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getExpectTimes() {
        return expectTimes;
    }

    public void setExpectTimes(Integer expectTimes) {
        this.expectTimes = expectTimes;
    }

    public Integer getPollingPeriod() {
        return pollingPeriod;
    }

    public void setPollingPeriod(Integer pollingPeriod) {
        this.pollingPeriod = pollingPeriod;
    }

    public Integer getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(Integer periodDay) {
        this.periodDay = periodDay;
    }

    public Integer getPeriodWeekday() {
        return periodWeekday;
    }

    public void setPeriodWeekday(Integer periodWeekday) {
        this.periodWeekday = periodWeekday;
    }

    public Integer getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(Integer periodMonth) {
        this.periodMonth = periodMonth;
    }

    public Integer getMoment() {
        return moment;
    }

    public void setMoment(Integer moment) {
        this.moment = moment;
    }

    public String getMomentValue() {
        return momentValue;
    }

    public void setMomentValue(String momentValue) {
        this.momentValue = momentValue == null ? null : momentValue.trim();
    }

    public String getBeginingTime() {
        return beginingTime;
    }

    public void setBeginingTime(String beginingTime) {
        this.beginingTime = beginingTime == null ? null : beginingTime.trim();
    }

    public Integer getInBetween() {
        return inBetween;
    }

    public void setInBetween(Integer inBetween) {
        this.inBetween = inBetween;
    }

    public Integer getIsBefor() {
        return isBefor;
    }

    public void setIsBefor(Integer isBefor) {
        this.isBefor = isBefor;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTimerMode() {
        return timerMode;
    }

    public void setTimerMode(Integer timerMode) {
        this.timerMode = timerMode;
    }

    public Integer getRemindWay() {
        return remindWay;
    }

    public void setRemindWay(Integer remindWay) {
        this.remindWay = remindWay;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    @Override
	public String toString() {
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		return JSONObject.fromObject(this,jsonConfig).toString();
	}
}