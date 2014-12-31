package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/25/14.
 */
public class ThreeSumZeroTest {
	@Test
	public void testThreeSumZero() {
		Assert.assertEquals(1, new ThreeSumZero().threeSumZero(new int[] {0,0,0}).size());
		Assert.assertEquals(1, new ThreeSumZero().threeSumZero(new int[] {1,-1,0,1,-1,0}).size());
	}
}
