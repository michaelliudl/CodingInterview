package com.leetcode.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 9/4/14.
 */
public class UniquePathsTest {
	@Test
	public void testUniquePaths() {
		UniquePaths path = new UniquePaths();
		Assert.assertEquals(20, path.uniquePathsMemoization(4, 4));
	}

}
