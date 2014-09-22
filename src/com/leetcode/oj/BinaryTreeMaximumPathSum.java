package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 9/10/14.
 */
public class BinaryTreeMaximumPathSum {

	private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		dfs(root);
		return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
	}

	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int leftSum = dfs(root.left);
		int rightSum = dfs(root.right);
		int sum = root.val;
		if (leftSum > 0) sum += leftSum;
		if (rightSum > 0) sum += rightSum;
		maxSum = Math.max(maxSum, sum);
		return Math.max(leftSum, rightSum) > 0 ? root.val + Math.max(leftSum, rightSum) : root.val;
	}
}
