package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by doliu on 8/27/14.
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left != null && right != null) {
			return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
		return false;
	}

	public boolean isSymmetricIterative(TreeNode root) {
		if (root == null) return true;
		TreeNode dummyLeaf = new TreeNode(Integer.MIN_VALUE);
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root.left == null ? dummyLeaf : root.left);
		stack.push(root.right == null ? dummyLeaf : root.right);
		while (!stack.isEmpty()) {
			TreeNode right = stack.pop();
			TreeNode left = stack.pop();
			if (left.val != right.val) return false;
			if (left != dummyLeaf && right != dummyLeaf) {
				stack.push(left.left == null ? dummyLeaf : left.left);
				stack.push(right.right == null ? dummyLeaf : right.right);
				stack.push(left.right == null ? dummyLeaf : left.right);
				stack.push(right.left == null ? dummyLeaf : right.left);
			}
		}
		return true;
	}
}
