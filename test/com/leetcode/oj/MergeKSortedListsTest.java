package com.leetcode.oj;

import beans.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by doliu on 9/3/14.
 */
public class MergeKSortedListsTest {
	@Test
	public void testMergeKLists() {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(8);
		head1.next.next = new ListNode(90);
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(7);
		head2.next.next = new ListNode(100);
		head2.next.next.next = new ListNode(300);
		ListNode head3 = new ListNode(6);
		head3.next = new ListNode(20);
		ListNode head4 = new ListNode(30);
		MergeKSortedLists solution = new MergeKSortedLists();
		ListNode mergedHead = solution.mergeKLists(Arrays.asList(head1, head2, head3, head4));
		Assert.assertEquals(mergedHead, head1);
	}
}
