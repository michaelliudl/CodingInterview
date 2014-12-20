package com.leetcode.oj;

import beans.ListNode;

/**
 * Created by doliu on 8/20/14.
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, false);
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean addOne) {
		if (l1 == null && l2 == null) {
			if (addOne) return new ListNode(1);
			else return null;
		}
		if (l1 == null) {
			if (addOne) {
				int val = l2.val + 1;
				if (val >= 10) {
					ListNode node = new ListNode(val - 10);
					node.next = addTwoNumbers(l1, l2.next, true);
					return node;
				} else {
					ListNode node = new ListNode(val);
					node.next = l2.next;
					return node;
				}
			} else {
				return l2;
			}
		}
		if (l2 == null) {
			if (addOne) {
				int val = l1.val + 1;
				if (val >= 10) {
					ListNode node = new ListNode(val - 10);
					node.next = addTwoNumbers(l1.next, l2, true);
					return node;
				} else {
					ListNode node = new ListNode(val);
					node.next = l1.next;
					return node;
				}
			} else {
				return l1;
			}
		}
		int val = l1.val + l2.val;
		if (addOne) {
			val += 1;
		}
		if (val >= 10) {
			ListNode node = new ListNode(val - 10);
			node.next = addTwoNumbers(l1.next, l2.next, true);
			return node;
		} else {
			ListNode node = new ListNode(val);
			node.next = addTwoNumbers(l1.next, l2.next, false);
			return node;
		}
	}

	public ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		int carry = 0;
		ListNode prev = dummy;
		for (ListNode p1 = l1, p2 = l2;
				p1 != null || p2 != null;
				p1 = p1 == null ? null : p1.next,
				p2 = p2 == null ? null : p2.next,
				prev = prev.next) {
			int v1 = p1 == null ? 0 : p1.val;
			int v2 = p2 == null ? 0 : p2.val;
			prev.next = new ListNode((v1 + v2 + carry) % 10);
			carry = (v1 + v2 + carry) / 10;
		}
		if (carry > 0) prev.next = new ListNode(carry);
		return dummy.next;
	}
}
