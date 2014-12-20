package com.leetcode.oj;

import beans.ListNode;
import org.junit.Test;

/**
 * Created by doliu on 9/2/14.
 */
public class ReverseNodesInKGroupTest {
	@Test
	public void testReverseKGroup() {
		ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
		ListNode cur = dummyHead;
		for (int i = 0; i < 3; i++) {
			cur.next = new ListNode(i + 1);
			cur = cur.next;
		}
		ReverseNodesInKGroup problem = new ReverseNodesInKGroup();
		problem.reverseKGroup(dummyHead.next, 3);
	}
}
