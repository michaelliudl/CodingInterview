package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

import java.util.*;

/**
 * Created by doliu on 8/12/14.
 */
public class BinaryTreeZigzagOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		boolean leftToRight = false;
		while (!queue.isEmpty()) {
			List<TreeNode> temp = new ArrayList<>();
			List<Integer> values = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				temp.add(node);
				values.add(node.val);
			}
			result.add(values);
			for (int i = temp.size() - 1; i >=0; i--) {
				TreeNode node = temp.get(i);
				if (leftToRight) {
					if (node.left != null) queue.offer(node.left);
					if (node.right != null) queue.offer(node.right);
				} else {
					if (node.right != null) queue.offer(node.right);
					if (node.left != null) queue.offer(node.left);
				}
			}
			leftToRight = !leftToRight;
		}
		return result;
	}
}
