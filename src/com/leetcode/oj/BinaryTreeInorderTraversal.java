package com.leetcode.oj;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by doliu on 8/12/14.
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		inorderTraversal(root, result);
		return result;
	}

	private void inorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) return;
		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right, result);
	}

	public List<Integer> inorderTraversalIterative(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else if (!stack.isEmpty()) {
				node = stack.pop();
				if (node != null) {
					result.add(node.val);
					node = node.right;
				}
			}
		}
		return result;
	}
}
