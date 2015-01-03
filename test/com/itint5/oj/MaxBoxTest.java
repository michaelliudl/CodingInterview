package com.itint5.oj;

import beans.Box;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 1/1/15.
 */
public class MaxBoxTest {
	@Test
	public void testMaxBoxes() {
		Assert.assertEquals(6, new MaxBox().maxBoxes(new Box[] {
				new Box(65, 100),
				new Box(70, 150),
				new Box(56, 90),
				new Box(75, 190),
				new Box(60, 95),
				new Box(68, 110),
				new Box(80, 12),
		}));
	}
}
