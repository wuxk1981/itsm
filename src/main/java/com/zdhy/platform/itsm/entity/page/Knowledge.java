package com.zdhy.platform.itsm.entity.page;
/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月10日-下午3:00:19
 * @version v1.0.0
 */
public class Knowledge {

	private String id;
	
	private String name;

	public String getId() {
		return id;
	}

	public Knowledge() {
		super();
	}

	public Knowledge(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

