package com.itint5.oj;

import beans.TreeNode;

import java.util.Arrays;

/**
 * Created by doliu on 12/14/14.
 */
public class MaxTreePathSum {

	private int max = 0;
	private TreeNode originalRoot;

	public int maxTreePathSum(TreeNode root) {
		if (root == null) return 0;
		originalRoot = originalRoot == null ? root : originalRoot;
		if (root.children == null || root.children.isEmpty()) return Math.max(root.val, 0);
		int len = root.children.size();
		int[] childrenSum = new int[len];
		for (int i = 0; i < root.children.size(); i++) {
			childrenSum[i] = maxTreePathSum(root.children.get(i));
		}
		Arrays.sort(childrenSum);
		int last = childrenSum[len - 1], lastSecond = len > 1 ? childrenSum[len - 2] : -1;
		int sum = root.val + last + Math.max(lastSecond, 0);
		max = Math.max(max, sum);
		max = Math.max(max, Math.max(root.val, Math.max(last, lastSecond)));
		if (root == originalRoot)
			return max;
		else
			return Math.max(Math.max(root.val + last, root.val), 0);
	}
}
