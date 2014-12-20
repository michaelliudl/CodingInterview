package com.leetcode.oj;

import beans.TreeNode;

/**
 * Created by doliu on 8/18/14.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null ||
				inorder.length == 0 || postorder.length == 0 ||
				inorder.length != postorder.length) return null;
		int len = inorder.length;
		return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
	}

	private TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if (instart == inend && poststart == postend) {
			return new TreeNode(inorder[instart]);
		}
		int rootPosInIn = instart, rootPosInPost = postend, rootVal = postorder[rootPosInPost];
		while (rootPosInIn <= inend) {
			if (inorder[rootPosInIn] == rootVal) {
				break;
			}
			rootPosInIn++;
		}
		int leftNodes = rootPosInIn - instart, rightNodes = inend - rootPosInIn;
		TreeNode root = new TreeNode(rootVal);
		if (leftNodes == 0) {
			root.left = null;
		} else {
			root.left = buildTree(inorder, instart, rootPosInIn - 1, postorder, poststart, postend - 1 - rightNodes);
		}
		if (rightNodes == 0) {
			root.right = null;
		} else {
			root.right = buildTree(inorder, rootPosInIn + 1, inend, postorder, postend - rightNodes, postend - 1);
		}
		return root;
	}
}
