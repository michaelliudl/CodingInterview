package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/13/14.
 */
public class MaxSubArrayCircleTest {
	@Test
	public void testMaxConsSum2() {
		Assert.assertEquals(16, new MaxSubArrayCircle().maxConsSum2(new int[] {6, -1, -6, 8, 2}));
		Assert.assertEquals(16, new MaxSubArrayCircle().maxConsSum2(new int[] {-6, 8, 2, 6, -1}));
		Assert.assertEquals(9, new MaxSubArrayCircle().maxConsSum2(new int[] {1, 3, -2, 6, -1}));
	}

	@Test
	public void testMaxConsSum2DuplicateArray() {
//		Assert.assertEquals(16, new MaxSubArrayCircle().maxConsSum2DuplicateArray(new int[] {6, -1, -6, 8, 2}));
//		Assert.assertEquals(16, new MaxSubArrayCircle().maxConsSum2DuplicateArray(new int[] {-6, 8, 2, 6, -1}));
		Assert.assertEquals(9, new MaxSubArrayCircle().maxConsSum2DuplicateArray(new int[] {1, 3, -2, 6, -1}));
	}
}
