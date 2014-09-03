package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;

import java.util.*;

/**
 * Created by doliu on 8/12/14.
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		postorderTraversal(root, result);
		return result;
	}

	private void postorderTraversal(TreeNode root, List<Integer> result) {
		if (root == null) return;
		postorderTraversal(root.left, result);
		postorderTraversal(root.right, result);
		result.add(root.val);
	}

	public List<Integer> postorderTraversalIterativeFromWiki(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		TreeNode lastVisited = null;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else if (!stack.isEmpty()) {
				TreeNode top = stack.peek();
				if (top != null) {
					if (top.right != null && lastVisited != top.right) {
						cur = top.right;
					} else {
						stack.pop();
						result.add(top.val);
						lastVisited = top;
					}
				}
			}
		}
		return result;
	}

	public List<Integer> postorderTraversalIterativeFromLeetcode(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				} else {
					result.add(cur.val);
					stack.pop();
				}
			} else if (prev == cur.left) {
				if (cur.right != null) {
					stack.push(cur.right);
				} else {
					result.add(cur.val);
					stack.pop();
				}
			} else if (prev == cur.right) {
				result.add(cur.val);
				stack.pop();
			}
			prev = cur;
		}
		return result;
	}

	public List<Integer> postorderTraversalIterativeFromLeetcodeRefactored(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<Integer> result = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
				} else if (cur.right != null) {
					stack.push(cur.right);
				}
			} else if (prev == cur.left) {
				if (cur.right != null) {
					stack.push(cur.right);
				}
			} else {
				result.add(cur.val);
				stack.pop();
			}
			prev = cur;
		}
		return result;
	}

	public List<Integer> postorderTraversalIterativeTwoStacks(TreeNode root) {
		if (root == null) return Collections.emptyList();
		Deque<TreeNode> firstStack = new ArrayDeque<>();
		firstStack.push(root);
		Deque<TreeNode> secondStack = new ArrayDeque<>();
		while (!firstStack.isEmpty()) {
			TreeNode top = firstStack.pop();
			secondStack.push(top);
			if (top.left != null) firstStack.push(top.left);
			if (top.right != null) firstStack.push(top.right);
		}
		List<Integer> result = new ArrayList<>();
		while (!secondStack.isEmpty())  {
			result.add(secondStack.pop().val);
		}
		return result;
	}
}
