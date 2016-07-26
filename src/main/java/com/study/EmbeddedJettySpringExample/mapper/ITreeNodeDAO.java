package com.study.EmbeddedJettySpringExample.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

import com.study.EmbeddedJettySpringExample.model.TreeNode;

public interface ITreeNodeDAO {

	public TreeNode queryTreeNodeById(String id);
	public Collection<TreeNode> queryChildTreeNodesById(@Param("id")String id, @Param("childLevel")Integer childLevel);
}
