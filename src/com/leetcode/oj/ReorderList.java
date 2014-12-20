package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 8/15/14.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		dummyHead.next = head;
		ListNode slow = dummyHead, fast = dummyHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// break into 2 lists, first one is longer for odd count
		ListNode secondHead = slow.next;
		slow.next = null;
		// reverse second list
		ListNode firstCur = head;
		ListNode secondCur = reverse(secondHead);
		// combine
		while (firstCur != null && secondCur != null) {
			ListNode firstNext = firstCur.next, secondNext = secondCur.next;
			firstCur.next = secondCur;
			secondCur.next = firstNext;
			firstCur = firstNext;
			secondCur = secondNext;
		}
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode prev = null, cur = head, next = cur.next;
		while (cur != null) {
			cur.next = prev;
			prev = cur;
			cur = next;
			next = next == null ? null : next.next;
		}
		return prev;
	}

	public void reorderListBrute(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;
		ListNode first = head;
		while (first != null && first.next != null && first.next.next != null) {
			ListNode nextFirst = first.next;
			ListNode tailPrev = first.next;
			ListNode tail = first.next.next;
			while (tail.next != null) {
				tailPrev = tail;
				tail = tail.next;
			}
			tailPrev.next = null;
			first.next = tail;
			tail.next = nextFirst;
			first = nextFirst;
		}
	}
}
