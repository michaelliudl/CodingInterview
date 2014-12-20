package com.itint5.oj;

import beans.Interval;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/14/14.
 */
public class IntervalIntersectedTest {
	@Test
	public void testIntersected() {
		int n = 3;
		Interval[] intervals = new Interval[] {new Interval(1,11), new Interval(13,15), new Interval(0,1)};
		boolean[] isIntersected = new boolean[3];
		new IntervalIntersected().intersected(intervals, isIntersected);
		Assert.assertTrue(isIntersected[0]);
		Assert.assertTrue(isIntersected[1]);
		Assert.assertFalse(isIntersected[2]);
	}
}
