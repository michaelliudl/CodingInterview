package com.careercup.crackingcodinginterview;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/14/14.
 */
public class Staircase9_1Test {
	@Test
	public void testCountWays() {
		Assert.assertEquals(1, new Staircase9_1().countWays(1));
		Assert.assertEquals(1, new Staircase9_1().countWaysDP(1));
		Assert.assertEquals(2, new Staircase9_1().countWays(2));
		Assert.assertEquals(2, new Staircase9_1().countWaysDP(2));
		Assert.assertEquals(4, new Staircase9_1().countWays(3));
		Assert.assertEquals(4, new Staircase9_1().countWaysDP(3));
		Assert.assertEquals(7, new Staircase9_1().countWays(4));
		Assert.assertEquals(7, new Staircase9_1().countWaysDP(4));
	}
}
