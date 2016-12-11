package com.zdhy.platform.itsm.entity.page;
/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月10日-下午3:00:19
 * @version v1.0.0
 */
public class Job {

	private String id;
	
	private String title;//标题
	
	private String status;//状态
	
	private String category;//分类
	
	private String createDate;//创建时间

	public Job(String id, String title, String status, String category,
			String createDate) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.category = category;
		this.createDate = createDate;
	}

	public Job() {
		super();
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	

	
	
}

