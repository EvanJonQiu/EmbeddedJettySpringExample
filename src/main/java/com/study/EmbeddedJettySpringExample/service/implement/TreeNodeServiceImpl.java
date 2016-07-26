package com.study.EmbeddedJettySpringExample.service.implement;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.study.EmbeddedJettySpringExample.mapper.ITreeNodeDAO;
import com.study.EmbeddedJettySpringExample.model.TreeNode;
import com.study.EmbeddedJettySpringExample.service.ITreeNodeService;
import com.study.EmbeddedJettySpringExample.service.dto.TreeListNode;

@Service
public class TreeNodeServiceImpl implements ITreeNodeService {
	
	private static final Logger logger = LoggerFactory.getLogger(TreeNodeServiceImpl.class);
	
	private static final Integer MAX_LEVEL = 3;
	
	@Autowired
	private ITreeNodeDAO treeNodeDAO;

	@Cacheable(value="treeNodeCache", key="#root.methodName+#id")
	public TreeNode queryTreeNodeById(String id) {
		logger.debug("TreeNodeServiceImpl.queryTreeNodeById");
		TreeNode treeNode = treeNodeDAO.queryTreeNodeById(id);
		return treeNode;
	}

	@Cacheable(value="treeNodeCache", key="#root.methodName+#id+'-'+#childLevel")
	public Collection<TreeNode> queryChildTreeNodesById(String id, Integer childLevel) {
		logger.debug("TreeNodeServiceImpl.queryChildTreeNodesById");
		return treeNodeDAO.queryChildTreeNodesById(id, childLevel);
	}
	
	@Cacheable(value="treeNodeCache", key="#root.methodName+#id")
	public TreeListNode queryChildTreeListById(String id) {
		logger.debug("TreeNodeServiceImpl.queryChildTreeListById");
		TreeListNode treeListNode = null;
		TreeNode firstNode = queryTreeNodeById(id);
		treeListNode = new TreeListNode(firstNode);
		if (firstNode.getLevel() == MAX_LEVEL) {
			return treeListNode;
		}
		Collection<TreeNode> childList = queryChildTreeNodesById(id, firstNode.getLevel() + 1);
		for (TreeNode item: childList) {
			TreeListNode subItem = null;
			if (item.getLevel() <= MAX_LEVEL) {
				subItem = queryChildTreeListById(item.getId());
			}
			treeListNode.getChildNodeList().add(subItem);
		}
		return treeListNode;
	}
	
	@Cacheable(value="treeNodeCache", key="#root.methodName+#id")
	public Collection<String> getQueryChildItemId(String id) {
		TreeListNode treeListNode = queryChildTreeListById(id);
		return getSubItemId(treeListNode);
	}
	
	private ArrayList<String> getSubItemId(TreeListNode node) {
		ArrayList<String> results = new ArrayList<String>();
		results.add(node.getId());
		
		if (!node.getChildNodeList().isEmpty()) {
			for (TreeListNode subNode: node.getChildNodeList()) {
				ArrayList<String> subResults = getSubItemId(subNode);
				results.addAll(subResults);
			}
		}
		
		return results;
	}
}
