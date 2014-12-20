package com.leetcode.oj;

import beans.TreeNode;

/**
 * Created by doliu on 8/19/14.
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int maxLeft = maxDepth(root.left);
		int maxRight = maxDepth(root.right);
		if (maxLeft > maxRight) return maxLeft + 1;
		else return maxRight + 1;
	}
}
