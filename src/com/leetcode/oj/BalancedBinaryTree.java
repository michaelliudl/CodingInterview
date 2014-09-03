package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 8/26/14.
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return binaryTreeHeight(root) >= 0;
	}

	private int binaryTreeHeight(TreeNode root) {
		if (root == null) return 0;
		int leftHeight = binaryTreeHeight(root.left);
		int rightHeight = binaryTreeHeight(root.right);
		if (leftHeight < 0 || rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) return -1;
		return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
	}
}
