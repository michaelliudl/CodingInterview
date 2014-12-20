package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 8/24/14.
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode cur = head, next = head.next;
		while (next != null) {
			if (next.val != cur.val) {
				cur.next = next;
				cur = next;
			}
			next = next.next;
		}
		cur.next = null;
		return head;
	}
}
