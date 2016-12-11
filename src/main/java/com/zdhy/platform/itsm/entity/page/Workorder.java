package com.zdhy.platform.itsm.entity.page;
/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月10日-下午4:39:47
 * @version v1.0.0
 */
public class Workorder {
	
	private String id;
	
	private String title;
	
	private String status;
	
	private String handleMan;
	
	private String createDate;

	public Workorder(){
		
	}
	
	public Workorder(String id, String title, String status, String handleMan,
			String createDate) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.handleMan = handleMan;
		this.createDate = createDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHandleMan() {
		return handleMan;
	}

	public void setHandleMan(String handleMan) {
		this.handleMan = handleMan;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

}

