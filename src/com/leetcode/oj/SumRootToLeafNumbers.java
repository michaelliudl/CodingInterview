package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 9/1/14.
 */
public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	private int sumNumbers(TreeNode root, int sum) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return sum + root.val;
		return sumNumbers(root.left, (sum + root.val) * 10)
				+ sumNumbers(root.right, (sum + root.val) * 10);
	}
}
