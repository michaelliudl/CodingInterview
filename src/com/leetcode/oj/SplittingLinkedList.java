package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 8/22/14.
 */
public class SplittingLinkedList {
	public void splitLinkedList(ListNode head, ListNode front, ListNode back) {
		front = back = head;
		if (head == null) return;
		ListNode slow = head, fast = head, frontLastNode = null;
		while (fast != null && fast.next != null) {
			frontLastNode = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null) {
			back = slow;
			frontLastNode = null;
		}
		else {
			back = slow.next;
			slow.next = null;
		}
	}
}
