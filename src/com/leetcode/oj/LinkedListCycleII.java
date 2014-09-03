package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doliu on 8/21/14.
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null) return null;
		Set<ListNode> visited = new HashSet<>();
		ListNode cur = head;
		while (cur != null) {
			if (visited.contains(cur)) {
				return cur;
			}
			visited.add(cur);
			cur = cur.next;
		}
		return null;
	}

	public ListNode detectCycleThreePointers(ListNode head) {
		if (head == null) return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow2 = head;
				while (slow != slow2) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow2;
			}
		}
		return null;
	}
}
