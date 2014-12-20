package com.leetcode.oj;

import beans.TreeNode;

/**
 * Created by doliu on 8/20/14.
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) return null;
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start == end) return new TreeNode(num[start]);
		int mid = (start + end) / 2;
		TreeNode cur = new TreeNode(num[mid]);
		if (mid > start) cur.left = sortedArrayToBST(num, start, mid - 1);
		if (mid < end) cur.right = sortedArrayToBST(num, mid + 1, end);
		return cur;
	}
}
