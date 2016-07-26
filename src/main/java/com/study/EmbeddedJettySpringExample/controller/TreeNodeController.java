package com.study.EmbeddedJettySpringExample.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.EmbeddedJettySpringExample.model.TreeNode;
import com.study.EmbeddedJettySpringExample.service.ITreeNodeService;
import com.study.EmbeddedJettySpringExample.service.dto.TreeListNode;

@Controller
public class TreeNodeController {

	private static final Logger logger = LoggerFactory.getLogger(TreeNodeController.class);
	
	@Autowired
	private ITreeNodeService treeNodeService;
	
	@RequestMapping(value="/queryTreeNodeById")
	@ResponseBody
	public TreeNode queryTreeNodeById(String id) {
		logger.debug("TreeNodeController.queryTreeNodeById");
		TreeNode treeNode = treeNodeService.queryTreeNodeById(id);
		return treeNode;
	}
	
	@RequestMapping(value="/queryChildTreeNodesById")
	@ResponseBody
	public Collection<TreeNode> queryChildTreeNodesById(String id, Integer childLevel) {
		logger.debug("TreeNodeController.queryChildTreeNodesById");
		return treeNodeService.queryChildTreeNodesById(id, childLevel);
	}
	
	@RequestMapping(value="/queryChildTreeListById")
	@ResponseBody
	public TreeListNode queryChildTreeListById(String id) {
		logger.debug("TreeNodeController.queryChildTreeListById");
		return treeNodeService.queryChildTreeListById(id);
	}
	
	@RequestMapping(value="/getQueryChildItemId")
	@ResponseBody
	public Collection<String> getQueryChildItemId(String id) {
		logger.debug("TreeNodeController.getQueryChildItemId");
		return treeNodeService.getQueryChildItemId(id);
	}
}
