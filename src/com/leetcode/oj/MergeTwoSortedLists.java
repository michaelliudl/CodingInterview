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

}
