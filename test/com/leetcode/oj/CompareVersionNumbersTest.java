package com.leetcode.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/18/14.
 */
public class CompareVersionNumbersTest {
	@Test
	public void testCompareVersion() {
		Assert.assertEquals(1, new CompareVersionNumbers().compareVersion("1", "0"));
	}
}
