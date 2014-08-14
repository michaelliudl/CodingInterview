package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 6/12/14.
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.val == sum) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}