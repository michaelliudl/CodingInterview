package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 9/13/14.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode lastSmall = dummyHead;
		while (lastSmall.next != null && lastSmall.next.val < x) {
			lastSmall = lastSmall.next;
		}
		ListNode cur = lastSmall.next, next = null;
		if (cur != null) next = cur.next;
		while (next != null) {
			if (next.val >= x) {
				cur = next;
				next = next.next;
			} else {
				cur.next = next.next;
				next.next = lastSmall.next;
				lastSmall.next = next;
				lastSmall = lastSmall.next;
				next = cur.next;
			}
		}
		return dummyHead.next;
	}
}
