package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 8/23/14.
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode prev = head, cur = head.next;
		while (cur != null) {
			if (cur.val < prev.val) {
				ListNode secondPrev = dummyHead, secondCur = dummyHead.next;
				while (secondCur.val < cur.val) {
					secondPrev = secondCur;
					secondCur = secondCur.next;
				}
				prev.next = cur.next;
				secondPrev.next = cur;
				cur.next = secondCur;
				cur = prev.next;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		return dummyHead.next;
	}
}
