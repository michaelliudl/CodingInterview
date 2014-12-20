package com.leetcode.oj;

import beans.RandomListNode;

/**
 * Created by doliu on 8/29/14.
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		// first round: insert copy of node after original node
		for (RandomListNode cur = head; cur != null; ) {
			RandomListNode copy = new RandomListNode(cur.label);
			copy.next = cur.next;
			cur.next = copy;
			cur = cur.next.next;
		}
		// second round: find equivalent copy of original random pointer
		for (RandomListNode cur = head; cur != null; cur = cur.next.next) {
			if (cur.random != null) cur.next.random = cur.random.next;
		}
		// third round: separate two lists and restore original
		RandomListNode dummyHead = new RandomListNode(Integer.MIN_VALUE);
		for (RandomListNode cur = head, copyCur = dummyHead; cur != null; cur = cur.next, copyCur = copyCur.next) {
			copyCur.next = cur.next;
			cur.next = copyCur.next.next;
		}
		return dummyHead.next;
	}
}
