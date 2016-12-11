package com.zdhy.platform.itsm.entity.page;
/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月10日-下午6:37:34
 * @version v1.0.0
 */
public class SysRunState {

	private String id;
	
	private String name;
	
	private String status;

	public SysRunState() {
		super();
	}

	public SysRunState(String id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}

