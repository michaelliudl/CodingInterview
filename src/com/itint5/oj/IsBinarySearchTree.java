package com.itint5.oj;

import beans.TreeNode;

/**
 * Created by doliu on 12/27/14.
 */
// 判断是否为二叉搜索树
public class IsBinarySearchTree {
	public boolean isBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(TreeNode root, int low, int high) {
		if (root == null) return true;
		return root.val > low && root.val <= high
				&& isBST(root.left, low, root.val)
				&& isBST(root.right, root.val, high);
	}
}
