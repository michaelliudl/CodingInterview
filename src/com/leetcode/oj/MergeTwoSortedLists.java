package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 5/12/14.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode ret = null;
		if (l1.val < l2.val) {
			ret = l1;
			ret.next = mergeTwoLists(l1.next, l2);
		} else {
			ret = l2;
			ret.next = mergeTwoLists(l1, l2.next);
		}
		return ret;
	}

	public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummyHead;
		ListNode p1 = l1, p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				cur.next = p1;
				p1 = p1.next;
			} else {
				cur.next = p2;
				p2 = p2.next;
			}
			cur = cur.next;
		}
		if (p1 != null) cur.next = p1;
		if (p2 != null) cur.next = p2;
		return dummyHead.next;
	}
}
