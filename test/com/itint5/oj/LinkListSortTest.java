package com.itint5.oj;

import beans.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/9/14.
 */
public class LinkListSortTest {
	@Test
	public void testSort() {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		ListNode newHead = new LinkListSort().sort(head);
		Assert.assertEquals(1, newHead.val);
		int count = 0;
		ListNode cur = newHead;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		Assert.assertEquals(3, count);
	}
}
