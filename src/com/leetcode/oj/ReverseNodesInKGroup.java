package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 9/2/14.
 */
public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode prevPrev = dummyHead, prev = head, cur = head.next, next = null;
		while (true) {
			ListNode node = prev;
			for (int i = 0; i < k; i++) {
				if (node == null) return dummyHead.next;
				else node = node.next;
			}
			next = cur.next;
			for (int i = 0; i < k - 1; i++) {
				cur.next = prev;
				if (i + 1 < k - 1) {
					prev = cur;
					cur = next;
					next = next.next;
				}
			}
			ListNode lastInGroup = prevPrev.next;
			prevPrev.next.next = next;
			prevPrev.next = cur;
			prevPrev = lastInGroup;
			prev = next;
			cur = next == null ? null : next.next;
			next = cur == null ? null : cur.next;
		}
	}
}
