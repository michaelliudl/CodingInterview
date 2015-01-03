package com.itint5.oj;

import com.lintcode.oj.Backpack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/12/14.
 */
public class BackpackTest {
	@Test
	public void testBackpack() {
		Assert.assertEquals(9, new Backpack().backPack(10, new int[] {3,4,8,5}));
	}
}
