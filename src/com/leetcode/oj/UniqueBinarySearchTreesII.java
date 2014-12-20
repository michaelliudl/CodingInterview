package com.leetcode.oj;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by doliu on 10/2/14.
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			List<TreeNode> result = new ArrayList<>();
			result.add(null);
			return result;
		}
		if (n == 1) return Arrays.asList(new TreeNode(n));
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> subTree = new ArrayList<>();
		if (start > end)
			subTree.add(null);
		else {
			for (int i = start; i <= end; i++) {
				List<TreeNode> leftSubTree = generateTrees(start, i - 1);
				List<TreeNode> rightSubTree = generateTrees(i + 1, end);
				for (TreeNode left : leftSubTree) {
					for (TreeNode right : rightSubTree) {
						TreeNode root = new TreeNode(i);
						root.left = left;
						root.right = right;
						subTree.add(root);
					}
				}
			}
		}
		return subTree;
	}
}
