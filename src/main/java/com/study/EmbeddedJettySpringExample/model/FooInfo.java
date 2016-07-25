package com.study.EmbeddedJettySpringExample.model;

import java.sql.Timestamp;

import com.study.EmbeddedJettySpringExample.util.BaseModel;

public class FooInfo extends BaseModel {

	private String id;
	private String name;
	private String createUsername;
	private Timestamp createTime;
	private String modifyUsername;
	private Timestamp modifyTime;
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
	public String getCreateUsername() {
		return createUsername;
	}
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getModifyUsername() {
		return modifyUsername;
	}
	public void setModifyUsername(String modifyUsername) {
		this.modifyUsername = modifyUsername;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Override
	public String toString() {
		return "FooInfo: <id=" + id + ", name=" + name
				+ ">";
	}
}
