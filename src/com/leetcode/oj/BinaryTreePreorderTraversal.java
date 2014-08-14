package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by doliu on 8/12/14.
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		preorderTraversal(root, result);
		return result;
	}

	private void preorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) return;
		result.add(root.val);
		preorderTraversal(root.left, result);
		preorderTraversal(root.right, result);
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				result.add(node.val);
				stack.push(node);
				node = node.left;
			} else if (!stack.isEmpty()) {
				node = stack.pop();
				if (node != null) node = node.right;
			}
		}
		return result;
	}
}
