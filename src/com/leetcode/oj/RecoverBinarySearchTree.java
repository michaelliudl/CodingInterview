package com.leetcode.oj;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by doliu on 9/15/14.
 */
public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
		if (root == null) return;
		List<TreeNode> inorder = inorder(root);
		TreeNode swapOne = null, swapTwo = null;
		for (int i = 0; i < inorder.size() - 1; i++) {
			if (inorder.get(i).val > inorder.get(i + 1).val) {
				swapOne = inorder.get(i);
				break;
			}
		}
		for (int i = inorder.size() - 1; i > 0; i--) {
			if (inorder.get(i).val < inorder.get(i - 1).val) {
				swapTwo = inorder.get(i);
				break;
			}
		}
		int temp = swapOne.val;
		swapOne.val = swapTwo.val;
		swapTwo.val = temp;
	}

	private List<TreeNode> inorder(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode top = stack.pop();
				result.add(top);
				cur = top.right;
			}
		}
		return result;
	}
}
