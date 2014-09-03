package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 8/31/14.
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode slow = dummyHead, fast = head;
		while (fast != null) {
			if (n > 0) {
				fast = fast.next;
				n--;
			} else {
				fast = fast.next;
				slow = slow.next;
			}
		}
		if (n > 0) return head;
		slow.next = slow.next.next;
		return dummyHead.next;
	}
}
