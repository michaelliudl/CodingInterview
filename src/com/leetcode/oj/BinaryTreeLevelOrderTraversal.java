package com.leetcode.oj;

import beans.TreeNode;

import java.util.*;

/**
 * Created by doliu on 8/12/14.
 */
public class BinaryTreeLevelOrderTraversal {
	// use only one queue
	public List<List<Integer>> levelOrderOptimized(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// track number of nodes in current level
			int n = queue.size();
			List<Integer> values = new ArrayList<>(n);
			while (!queue.isEmpty() && n > 0) {
				TreeNode node = queue.poll();
				values.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
				n--;
			}
			result.add(values);
		}
		return result;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// temporary queue/list for nodes in next level
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
