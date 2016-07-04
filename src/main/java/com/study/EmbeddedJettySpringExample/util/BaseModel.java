package com.study.EmbeddedJettySpringExample.util;

public class BaseModel {
	private PageParameter pageInfo = new PageParameter();  
    
    private String sort;  
      
    private String dir = "asc";

	public PageParameter getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageParameter pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}   
}

