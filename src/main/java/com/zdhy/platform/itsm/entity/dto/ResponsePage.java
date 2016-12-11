package com.zdhy.platform.itsm.entity.dto;

import java.util.List;

/**
 * 请求响应对象
 * @author xiaohui
 */
public class ResponsePage {

	private long total;						//总记录数量
	private Object rows;					//查询的记录集
	private Integer pageSize;				//每页记录数量
	private Integer totalPages;				//总页数
	private Integer pageNo;					//本次查询页号
	private Integer currentNumber;			//本次查询记录数量
	
	public ResponsePage() {
		super();
	}


	public ResponsePage(long total, List<Object> rows, Integer pageSize, Integer totalPages, Integer pageNo, Integer currentNumber) {
		super();
		this.total = total;
		this.rows = rows;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.pageNo = pageNo;
		this.currentNumber = currentNumber;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(Integer currentNumber) {
		this.currentNumber = currentNumber;
	}
	
}
