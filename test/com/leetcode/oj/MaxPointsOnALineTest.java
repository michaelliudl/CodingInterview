package com.leetcode.oj;

import com.leetcode.oj.beans.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by doliu on 9/5/14.
 */
public class MaxPointsOnALineTest {
	@Test
	public void testMaxPoints() {
		MaxPointsOnALine max = new MaxPointsOnALine();
		int n = max.maxPoints(new Point[] {new Point(84, 250),
				new Point(0, 0),
				new Point(1, 0),
				new Point(0, -70),
				new Point(1, -1),
				new Point(21, 10),
				new Point(42, 90),
				new Point(-42, -230),
		});
		Assert.assertEquals(6, n);
	}
}
