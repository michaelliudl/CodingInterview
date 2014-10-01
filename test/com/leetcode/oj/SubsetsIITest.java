package com.leetcode.oj;

import org.junit.Test;

/**
 * Created by doliu on 9/22/14.
 */
public class SubsetsIITest {
	@Test
	public void testSubsetsWithDup() {
		new SubsetsII().subsetsWithDup(new int[] {1,2,3,4,5,6,7,8,10,0});
	}

	@Test
	public void testSubsetsWithDupIterative() {
		new SubsetsII().subsetsWithDupIterative(new int[] {1,4,3,5,4,4,7,7,8,0});
	}
}
