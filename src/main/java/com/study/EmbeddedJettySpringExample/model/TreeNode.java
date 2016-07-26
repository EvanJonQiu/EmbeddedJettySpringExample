package com.study.EmbeddedJettySpringExample.model;

public class TreeNode {
	
	protected String id;
	protected String name;
	protected String level1Id;
	protected String level2Id;
	protected String level3Id;
	protected Integer level;
	protected String parentId;
	protected Integer orderId;
	
	public TreeNode() {
		
	}
	
	public TreeNode(TreeNode treeNode) {
		this.setId(treeNode.getId());
		this.setName(treeNode.getName());
		this.setLevel1Id(treeNode.getLevel1Id());
		this.setLevel2Id(treeNode.getLevel2Id());
		this.setLevel3Id(treeNode.getLevel3Id());
		this.setLevel(treeNode.getLevel());
		this.setParentId(treeNode.getParentId());
		this.setOrderId(treeNode.getOrderId());
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
	public String getLevel1Id() {
		return level1Id;
	}
	public void setLevel1Id(String level1Id) {
		this.level1Id = level1Id;
	}
	public String getLevel2Id() {
		return level2Id;
	}
	public void setLevel2Id(String level2Id) {
		this.level2Id = level2Id;
	}
	public String getLevel3Id() {
		return level3Id;
	}
	public void setLevel3Id(String level3Id) {
		this.level3Id = level3Id;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
