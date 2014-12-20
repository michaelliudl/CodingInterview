package com.leetcode.oj;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 10/2/14.
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> curPath = new ArrayList<>();
		dfs(root, sum, curPath, result);
		return result;
	}

	private void dfs(TreeNode node, int sum, List<Integer> curPath, List<List<Integer>> result) {
		if (node == null) return;
		curPath.add(node.val);
		if (node.left == null && node.right == null && sum == node.val) {
			List<Integer> copy = new ArrayList<>(curPath.size());
			for (int i : curPath) copy.add(i);
			result.add(copy);
		}
		dfs(node.left, sum - node.val, curPath, result);
		dfs(node.right, sum - node.val, curPath, result);
		curPath.remove(curPath.size() - 1);
	}
}
