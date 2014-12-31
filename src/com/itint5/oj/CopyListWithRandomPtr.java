package com.itint5.oj;

import beans.ListNode;

/**
 * Created by doliu on 12/27/14.
 */
// 复制带随机指针的链表
public class CopyListWithRandomPtr {
	public ListNode copyListWithRandomPtr(ListNode head) {
		if (head == null) return null;
		ListNode node = head;
		while (node != null) {
			ListNode copy = new ListNode();
			copy.next = node.next;
			node.next = copy;
			node = copy.next;
		}
		ListNode copyHead = head.next;
		node = head;
		while (node != null) {
			node.next.random = node.random.next;
			node = node.next.next;
		}
		node = head;
		while (node != null) {
			ListNode next = node.next.next;
			node.next.next = next == null ? null : next.next;
			node.next = next;
			node = next;
		}
		return copyHead;
	}
}
