package com.itint5.oj;

import beans.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by doliu on 12/31/14.
 */
// 二叉树转换线索二叉树
public class ThreadedBinaryTree {
	// 树结点除了包含left, right指针外，还包含isLeftThread和isRightThread，初始时isLeftThread和isRightThread都为false。
	// 对于left为null的结点，请将left设置为中序遍历该结点的前驱结点，并将isLeftThread设置为true。
	// 对于right为null的结点，请将right设置为中序遍历该结点的后继结点，并将isRightThread设置为true。

	private TreeNode prev = null;

	/**
	 * Recursive solution
	 * @param root
	 */
	public void convertToThreadedTreeRecursive(TreeNode root) {
		if (root == null) return;
		convertToThreadedTree(root);
	}

	private void convertToThreadedTree(TreeNode root) {
		if (root == null) return;
		convertToThreadedTree(root.left);
		if (prev != null) {
			if (prev.right == null) {
				prev.right = root;
				prev.isRightThread = true;
			}
			if (root.left == null) {
				root.left = prev;
				root.isLeftThread = true;
			}
		}
		prev = root;
		convertToThreadedTree(root.right);
	}

	/**
	 * Iterative solution
	 * @param root
	 */
	public void convertToThreadedTreeIterative(TreeNode root) {
		if (root == null) return;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root, prev = null;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.pop();
				if (prev != null) {
					if (prev.right == null) {
						prev.right = node;
						prev.isRightThread = true;
					}
					if (node.left == null) {
						node.left = prev;
						node.isLeftThread = true;
					}
				}
				prev = node;
				cur = node.right;
			}
		}
	}
}
