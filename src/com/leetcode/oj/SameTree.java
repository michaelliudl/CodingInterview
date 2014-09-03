package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 8/19/14.
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p != null && q != null) {
			return p.val == q.val
					&& isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right);
		}
		return false;
	}
}
