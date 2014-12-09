package com.leetcode.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/2/14.
 */
public class RegularExpressionMatchingTest {
	@Test
	public void testIsMatch() {
		Assert.assertTrue(new RegularExpressionMatching().isMatch("a", "ab*"));
	}
}
