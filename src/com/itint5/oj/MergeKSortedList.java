package com.itint5.oj;

import beans.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by doliu on 12/26/14.
 */
// 合并K个有序链表
public class MergeKSortedList {
	// lists包含k个链表头结点,返回合并后链表头结点
	// O(n*lgK) with min heap
	public ListNode mergeWithHeap(List<ListNode> lists) {
		if (lists == null || lists.isEmpty()) return null;
		if (lists.size() == 1) return lists.get(0);
		PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(),
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});
		for (ListNode node : lists) if (node != null) heap.offer(node);
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (!heap.isEmpty()) {
			ListNode min = heap.poll();
			cur.next = min;
			if (min.next != null) heap.offer(min.next);
			cur = cur.next;
		}
		return dummy.next;
	}

	// O(nK) time out
	public ListNode merge(List<ListNode> lists) {
		if (lists == null || lists.isEmpty()) return null;
		if (lists.size() == 1) return lists.get(0);
		ListNode result = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			result = mergeTwoLists(result, lists.get(i));
		}
		return result;
	}

	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
			cur = cur.next;
		}
		if (list1 != null) cur.next = list1;
		else cur.next = list2;
		return dummy.next;
	}
}
