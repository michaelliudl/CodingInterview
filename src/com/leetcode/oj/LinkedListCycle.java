package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doliu on 8/21/14.
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode cur = head;
		Set<ListNode> visited = new HashSet<>();
		while (cur != null) {
			if (visited.contains(cur)) {
				return true;
			} else {
				visited.add(cur);
				cur = cur.next;
			}
		}
		return false;
	}

	public boolean hasCycleSlowFastPointers(ListNode head) {
		if (head == null) return false;
		ListNode slow = head, fast = head;
		boolean started = false;
		while (fast != null && fast.next != null) {
			if (started && slow == fast) return true;
			slow = slow.next;
			fast = fast.next.next;
			if (!started) started = true;
		}
		return false;
	}
}
