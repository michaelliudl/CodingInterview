package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 9/14/14.
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null || n <= 0) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		int len = 0;
		ListNode last = dummyHead;
		while (last.next != null) {
			last = last.next;
			len++;
		}
		int rotate = n % len;
		if (rotate == 0) return head;
		ListNode lastNoRotate = dummyHead;
		for (int i = 0; i < len - rotate; i++) {
			lastNoRotate = lastNoRotate.next;
		}
		ListNode firstRotate = lastNoRotate.next;
		last.next = head;
		dummyHead.next = firstRotate;
		lastNoRotate.next = null;
		return dummyHead.next;
	}
}
