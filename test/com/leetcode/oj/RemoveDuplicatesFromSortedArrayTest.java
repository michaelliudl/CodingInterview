package com.leetcode.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 5/13/14.
 */
public class RemoveDuplicatesFromSortedArrayTest {
	private RemoveDuplicatesFromSortedArray solution = new  RemoveDuplicatesFromSortedArray();
	@Test
	public void testRemoveDuplicates() {
		int result = solution.removeDuplicates(new int[] {1, 2});
		Assert.assertEquals(2, result);
	}
}
