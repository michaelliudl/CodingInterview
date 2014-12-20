package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 8/30/14.
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode prev = dummyHead, cur = head, next = cur.next;
		while (next != null) {
			if (next.val == cur.val) next = next.next;
			else if (cur.next == next) {
				prev = cur;
				cur = next;
				next = next.next;
			} else {
				cur = next;
				next = next.next;
				prev.next = cur;
			}
		}
		if (cur.next != null) {
			prev.next = null;
		}
		return dummyHead.next;
	}
}
