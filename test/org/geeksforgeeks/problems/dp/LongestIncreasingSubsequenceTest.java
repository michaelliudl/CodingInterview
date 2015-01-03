package org.geeksforgeeks.problems.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 1/1/15.
 */
public class LongestIncreasingSubsequenceTest {
	@Test
	public void testLengthOfLIS() {
		Assert.assertEquals(6, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
		Assert.assertEquals(8, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 1, 2, 3, 4, 5, 6, 7, 8}));
		Assert.assertEquals(6, new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
	}
}
