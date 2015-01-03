package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 1/2/15.
 */
public class EvaluationTest {
	@Test
	public void testEvaluateWithRPN() {
		Assert.assertEquals(22, new Evaluation().evaluateWithRPN("(3+3)*4-(8/4)"));
	}

	@Test
	public void testEvaluate() {
		Assert.assertEquals(69, new Evaluation().evaluate("7+3*4*5+2+4-3-1"));
	}
}
