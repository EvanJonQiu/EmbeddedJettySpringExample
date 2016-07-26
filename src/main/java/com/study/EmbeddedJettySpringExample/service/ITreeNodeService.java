package com.study.EmbeddedJettySpringExample.service;

import java.util.Collection;

import com.study.EmbeddedJettySpringExample.model.TreeNode;
import com.study.EmbeddedJettySpringExample.service.dto.TreeListNode;

public interface ITreeNodeService {

	public TreeNode queryTreeNodeById(String id);
	public Collection<TreeNode> queryChildTreeNodesById(String id, Integer childLevel);
	public TreeListNode queryChildTreeListById(String id);
	public Collection<String> getQueryChildItemId(String id);
}
