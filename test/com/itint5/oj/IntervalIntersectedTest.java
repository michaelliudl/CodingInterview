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
		new IntervalIntersected().intersectedBrute(intervals, isIntersected);
		Assert.assertTrue(isIntersected[0]);
		Assert.assertFalse(isIntersected[1]);
		Assert.assertTrue(isIntersected[2]);
	}

	@Test
	public void testIntersectedSort() {
		int n = 7;
		Interval[] intervals = new Interval[] {new Interval(32,40), new Interval(8,12), new Interval(0,10),
				new Interval(14,16), new Interval(1,3), new Interval(25,28), new Interval(20,30)};
		boolean[] isIntersected = new boolean[7];
		new IntervalIntersected().intersected(intervals, isIntersected);
		Assert.assertTrue(isIntersected[0]);
		Assert.assertFalse(isIntersected[1]);
		Assert.assertTrue(isIntersected[2]);
	}
}
