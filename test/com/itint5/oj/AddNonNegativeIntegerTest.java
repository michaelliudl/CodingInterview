package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 1/2/15.
 */
public class AddNonNegativeIntegerTest {
	@Test
	public void testAdd() {
		Assert.assertEquals("45801", new AddNonNegativeInteger().add("123", "45678"));
	}
}
