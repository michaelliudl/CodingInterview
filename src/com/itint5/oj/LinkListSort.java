package com.itint5.oj;

import beans.ListNode;

/**
 * Created by doliu on 12/9/14.
 */
public class LinkListSort {
	public ListNode sort(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode part1 = head, part2 = slow.next;
		slow.next = null;
		part1 = sort(part1);
		part2 = sort(part2);
		return merge(part1, part2);
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null) return head2;
		if (head2 == null) return head1;
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head1 != null) cur.next = head1;
		if (head2 != null) cur.next = head2;
		return dummy.next;
	}
}
