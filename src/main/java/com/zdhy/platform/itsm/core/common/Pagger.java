package com.zdhy.platform.itsm.core.common;

import java.util.List;

public class Pagger<T> {
	private int totalNum;

	private List<T> results;

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

}
