package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 8/22/14.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m <= 0 || n <= 0 || m >= n) return head;
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prevStart = dummyHead;
		ListNode start = head;
		for (int i = 1; i < m; i++) {
			if (start == null) break;
			prevStart = prevStart.next;
			start = start.next;
		}
		ListNode first = start, second = start.next, third = start.next.next;
		for (int i = m; i < n; i++) {
			if (first == null || second == null) break;
			second.next = first;
			first = second;
			second = third;
			if (third != null) third = third.next;
		}
		prevStart.next = first;
		start.next = second;
		return dummyHead.next;
	}
}
