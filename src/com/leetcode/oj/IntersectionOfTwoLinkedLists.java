package com.leetcode.oj;

import com.leetcode.oj.beans.ListNode;

/**
 * Created by doliu on 12/2/14.
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode pA = headA, pB = headB;
		int lenA = getLen(headA), lenB = getLen(headB);
		int diff = Math.abs(lenA - lenB);
		while (diff > 0) {
			if (lenA > lenB) pA = pA.next;
			else pB = pB.next;
			diff--;
		}
		while (pA != null && pB != null) {
			if (pA == pB) return pA;
			pA = pA.next;
			pB = pB.next;
		}
		return null;
	}

	private int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
