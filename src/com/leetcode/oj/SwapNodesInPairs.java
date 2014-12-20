package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 8/26/14.
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode prevPrev = dummyHead, prev = head, cur = head.next, next = head.next.next;
		while (cur != null) {
			cur.next = prev;
			prevPrev.next = cur;
			prev.next = next;
			prevPrev = prev;
			prev = next;
			if (next != null) cur = next.next;
			else cur = null;
			if (next != null && next.next != null) next = next.next.next;
			else next = null;
		}
		return dummyHead.next;
	}
}
