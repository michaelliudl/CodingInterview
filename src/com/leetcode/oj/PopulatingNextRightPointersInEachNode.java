package com.leetcode.oj;

import beans.TreeLinkNode;

/**
 * Created by doliu on 8/20/14.
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		connect(root, null);
	}

	private void connect(TreeLinkNode root, TreeLinkNode sibling) {
		if (root == null) return;
		else root.next = sibling;
		connect(root.left, root.right);
		if (sibling != null) connect(root.right, sibling.left);
		else connect(root.right, null);
	}

	public void connectIterative(TreeLinkNode root) {
		TreeLinkNode leftChild = root;
		while (leftChild != null) {
			TreeLinkNode sibling = leftChild;
			while (sibling != null && sibling.left != null) {
				sibling.left.next = sibling.right;
				if (sibling.next != null) {
					sibling.right.next = sibling.next.left;
				}
				sibling = sibling.next;
			}
			leftChild = leftChild.left;
		}
	}
}
