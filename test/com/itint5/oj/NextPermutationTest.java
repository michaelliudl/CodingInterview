package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/14/14.
 */
public class NextPermutationTest {
	@Test
	public void testNextPermutation() {
		int[] arr = new int[] {1,2,1};
		Assert.assertTrue(new NextPermutation().nextPermutation(arr));
		Assert.assertArrayEquals(new int[] {2,1,1}, arr);
	}
}
