package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/20/14.
 */
public class ParenthesesGeneratorTest {
	@Test
	public void testGenerate() {
		ParenthesesGenerator pg = new ParenthesesGenerator();
		Assert.assertEquals(5, pg.generate(3).size());
	}
}
