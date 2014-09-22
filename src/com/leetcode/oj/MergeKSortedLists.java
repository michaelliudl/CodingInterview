package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

import java.util.List;

/**
 * Created by doliu on 8/24/14.
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) return null;
		if (lists.size() == 1) return lists.get(0);
		ListNode p = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			p = mergeTwoLists(p, lists.get(i));
		}
		return p;
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

	public ListNode mergeKListsBrute(List<ListNode> lists) {
		if (lists == null) return null;
		if (lists.size() == 1) return lists.get(0);
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummyHead;
		int smallest = findSmallest(lists, dummyHead);
		while (smallest >= 0) {
			cur.next = lists.get(smallest);
			cur = cur.next;
			if (lists.get(smallest).next == null) {
				lists.set(smallest, dummyHead);
			} else {
				lists.set(smallest, lists.get(smallest).next);
			}
			smallest = findSmallest(lists, dummyHead);
		}
		return dummyHead.next;
	}

	private int findSmallest(List<ListNode> lists, ListNode dummyHead) {
		int index = -1, value = Integer.MAX_VALUE;
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null && lists.get(i) != dummyHead && lists.get(i).val < value) {
				index = i;
				value = lists.get(i).val;
			}
		}
		return index;
	}
}
