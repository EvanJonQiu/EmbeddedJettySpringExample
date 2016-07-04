package com.study.EmbeddedJettySpringExample.util;

public class PageParameter {
	private int totalCount;
    private int totalPage = Integer.MAX_VALUE;  // 最大页数
    private int currentPage = 1;// 当前页码
    private int pageSize = 25;  // 每页显示记录数
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
