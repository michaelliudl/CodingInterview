package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 8/26/14.
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode slow = dummyHead, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHead = slow.next;
		slow.next = null;
		ListNode firstSorted = sortList(head);
		ListNode secondSorted = sortList(secondHead);
		return mergeSorted(firstSorted, secondSorted);
	}

	private ListNode mergeSorted(ListNode firstSorted, ListNode secondSorted) {
		if (firstSorted == null) return secondSorted;
		if (secondSorted == null) return firstSorted;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummyHead;
		while (firstSorted != null && secondSorted != null) {
			if (firstSorted.val <= secondSorted.val) {
				cur.next = firstSorted;
				firstSorted = firstSorted.next;
			} else {
				cur.next = secondSorted;
				secondSorted = secondSorted.next;
			}
			cur = cur.next;
		}
		if (firstSorted == null) cur.next = secondSorted;
		else cur.next = firstSorted;
		return dummyHead.next;
	}
}
