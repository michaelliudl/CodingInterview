package com.leetcode.oj;

import beans.TreeNode;

/**
 * Created by doliu on 8/30/14.
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		flattenSubTree(root);
	}

	private TreeNode flattenSubTree(TreeNode root) {
		if (root == null) return null;
		TreeNode flattenLeft = flattenSubTree(root.left);
		TreeNode flattenRight = flattenSubTree(root.right);
		root.left = null;
		if (flattenLeft != null) {
			root.right = flattenLeft;
			if (flattenRight != null) {
				TreeNode leftLast = flattenLeft;
				while (leftLast.right != null) {
					leftLast = leftLast.right;
				}
				leftLast.right = flattenRight;
			}
		} else {
			root.right = flattenRight;
		}
		return root;
	}
}
