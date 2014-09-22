package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;
import com.leetcode.oj.beans.TreeNode;

/**
 * Created by doliu on 5/12/14.
 */
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode prev = dummyHead, cur = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = prev.next;
			cur = cur.next;
			fast = fast.next.next;
		}
		ListNode left = head, right = cur.next;
		prev.next = null;
		cur.next = null;
		TreeNode root = new TreeNode(cur.val);
		root.left = sortedListToBST(left);
		root.right = sortedListToBST(right);
		return root;
	}
}
