package org.uva.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/13/14.
 */
public class ThreeNPlusOneTest {
	@Test
	public void testSolve() {
		ThreeNPlusOne inst = new ThreeNPlusOne();
		Assert.assertEquals(16, inst.findCycle(22));
	}

	@Test
	public void testOutput() {
		ThreeNPlusOne inst = new ThreeNPlusOne();
		inst.output(new int[] {1, 10, 20});
	}

	@Test
	public void testSolveRange() {
		ThreeNPlusOne inst = new ThreeNPlusOne();
		inst.solve("1 10");
		inst.solve("100 200");
		inst.solve("201 210");
		inst.solve("900 1000");
	}
}
