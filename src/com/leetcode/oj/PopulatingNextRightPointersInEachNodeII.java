package com.leetcode.oj;

import beans.TreeLinkNode;

/**
 * Created by doliu on 8/20/14.
 */
public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode dummy = new TreeLinkNode(Integer.MIN_VALUE);
		TreeLinkNode cur = root, prev = dummy;
		while (cur != null) { // iterate on current level, connect one level below
			if (cur.left != null) {
				prev.next = cur.left;
				prev = prev.next;
			}
			if (cur.right != null) {
				prev.next = cur.right;
				prev = prev.next;
			}
			cur = cur.next;
		}
		connect(dummy.next); // dummy points to leftest node one level below current
	}

	public void connectIterative(TreeLinkNode root) {
		TreeLinkNode cur = root;
		while (cur != null) {
			TreeLinkNode nextLevelFirst = null; // iterate on first node of each level
			TreeLinkNode prev = new TreeLinkNode(Integer.MIN_VALUE); // start from dummy head on next level which to be connected
			while (cur != null) {
				if (nextLevelFirst == null) nextLevelFirst = cur.left != null ? cur.left : cur.right;
				if (cur.left != null) {
					prev.next = cur.left;
					prev = prev.next;
				}
				if (cur.right != null) {
					prev.next = cur.right;
					prev = prev.next;
				}
				cur = cur.next;
			}
			cur = nextLevelFirst;
		}
	}
}
