package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/14/14.
 */
public class CandyTest {
	@Test
	public void testMinimalCandies() {
		int[] r = new int[100000];
		for (int i = 0; i < r.length; i++)
			r[i] = i;
		Assert.assertEquals(5000050000L, new Candy().minimalCandies(r));
	}

	@Test
	public void testMinimalCandies_1() {
		int[] r = new int[100000];
		for (int i = 0; i < r.length; i++)
			r[i] = i;
		Assert.assertEquals(5000050000L, new Candy().minimalCandies_1(r));
	}
}
