package com.leetcode.oj;

import beans.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 9/5/14.
 */
public class MaxPointsOnALineTest {
	@Test
	public void testMaxPoints() {
		MaxPointsOnALine max = new MaxPointsOnALine();
		int n = max.maxPointsPointOriented(new Point[] {new Point(1, 1),
				new Point(1, 1),
				new Point(2, 2),
				new Point(2, 2),
		});
		Assert.assertEquals(3, n);
	}
}
