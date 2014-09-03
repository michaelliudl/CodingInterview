package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 8/22/14.
 */
public class ReverseLinkedList {
	public ListNode reverseIterative(ListNode head) {
		if (head == null) return head;
		ListNode first = null, second = head, third = head.next;
		while (second != null) {
			second.next = first;
			first = second;
			second = third;
			if (third != null) third = third.next;
		}
		return first;
	}

	public ListNode reverseIterative1(ListNode head) {
		if (head == null) return head;
		ListNode prev = null, cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public ListNode reverseRecursive(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode next = head.next;
		head.next = null;
		ListNode reversed = reverseRecursive(next);
		next.next = head;
		return reversed == null ? next : reversed;
	}
}
