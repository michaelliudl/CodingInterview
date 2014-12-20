package com.leetcode.oj;

import beans.TreeNode;

import java.util.*;

/**
 * Created by doliu on 8/12/14.
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<TreeNode> temp = new ArrayList<>();
			List<Integer> values = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				temp.add(node);
				values.add(node.val);
			}
			result.add(values);
			for (TreeNode node : temp) {
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
		}
		return result;
	}
}
