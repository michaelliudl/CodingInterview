package com.leetcode.oj;

import beans.TreeNode;

import java.util.*;

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

	public List<Integer> preorderTraversalIterativeFromLeetCode(TreeNode root) {
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

	public List<Integer> preorderTraversalIterativeFromWiki(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		while (cur != null) {
			result.add(cur.val);
			if (cur.right != null) stack.push(cur.right);
			if (cur.left != null) stack.push(cur.left);
			if (stack.isEmpty()) cur = null;
			else cur = stack.pop();
		}
		return result;
	}
}
