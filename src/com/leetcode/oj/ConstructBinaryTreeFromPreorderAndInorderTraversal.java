package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 8/18/14.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null ||
				preorder.length == 0 || inorder.length == 0 ||
				preorder.length != inorder.length) return null;
		int rootValue = preorder[0];
		TreeNode root = new TreeNode(rootValue);
		int pos = 0;
		while (pos < inorder.length) {
			if (inorder[pos] == rootValue) break;
			pos++;
		}
		int len = preorder.length;
		int leftLen = pos;
		int[] leftPreorder = new int[leftLen];
		int[] leftInorder = new int[leftLen];
		System.arraycopy(preorder, 1, leftPreorder, 0, leftLen);
		System.arraycopy(inorder, 0, leftInorder, 0, leftLen);
		root.left = buildTree(leftPreorder, leftInorder);
		int rightLen = len - leftLen - 1;
		int[] rightPreorder = new int[rightLen];
		int[] rightInorder = new int[rightLen];
		System.arraycopy(preorder, pos + 1, rightPreorder, 0, rightLen);
		System.arraycopy(inorder, pos + 1, rightInorder, 0, rightLen);
		root.right = buildTree(rightPreorder, rightInorder);
		return root;
	}
}
