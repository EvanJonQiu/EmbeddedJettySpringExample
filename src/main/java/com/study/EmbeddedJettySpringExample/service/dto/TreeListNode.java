package com.study.EmbeddedJettySpringExample.service.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.study.EmbeddedJettySpringExample.model.TreeNode;

public class TreeListNode extends TreeNode {
	
	protected Collection<TreeListNode> childNodeList = new ArrayList<TreeListNode>();
	
	public TreeListNode() {
		
	}
	
	public TreeListNode(TreeNode treeNode) {
		super(treeNode);
	}

	public Collection<TreeListNode> getChildNodeList() {
		return childNodeList;
	}

	public void setChildNodeList(Collection<TreeListNode> childNodeList) {
		this.childNodeList = childNodeList;
	}

}
