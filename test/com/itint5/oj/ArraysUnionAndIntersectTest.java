package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/29/14.
 */
public class ArraysUnionAndIntersectTest {
	@Test
	public void testArrayUnion() {
		ArraysUnionAndIntersect arrays = new ArraysUnionAndIntersect();
		Assert.assertArrayEquals(new int[] {1}, arrays.arrayUnion(new int[0], new int[]{1, 1}));
	}
}
