package com.zdhy.platform.itsm.entity.page;
/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月10日-下午6:06:38
 * @version v1.0.0
 */
public class Channel {

	private String id;
	
	private String name;

	public Channel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Channel() {
		super();
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
	
	
}

