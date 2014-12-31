package com.itint5.oj;

import beans.TreeNode;

/**
 * Created by doliu on 12/27/14.
 */
// 判断是否为平衡二叉树
public class IsBalancedTree {
	public boolean isBalancedTree(TreeNode root) {
		return balancedTreeHeight(root) >= 0;
	}

	private int balancedTreeHeight(TreeNode root) {
		if (root == null) return 0;
		int left = balancedTreeHeight(root.left);
		int right = balancedTreeHeight(root.right);
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
		return Math.max(left, right) + 1;
	}
}
