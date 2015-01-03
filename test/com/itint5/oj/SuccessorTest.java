package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/31/14.
 */
public class SuccessorTest {
	@Test
	public void testSuccessor() {
		Successor s = new Successor();
		s.init(7);
		Assert.assertEquals(5, s.query(5));
		s.removeNum(4);
		Assert.assertEquals(3, s.query(3));
		s.removeNum(3);
		Assert.assertEquals(5, s.query(3));
		Assert.assertEquals(5, s.query(5));
		s.removeNum(5);
		s.removeNum(2);
		Assert.assertEquals(6, s.query(2));
		Assert.assertEquals(6, s.query(3));
		Assert.assertEquals(6, s.query(4));
		s.removeNum(1);
		Assert.assertEquals(0, s.query(0));
		Assert.assertEquals(6, s.query(2));
		Assert.assertEquals(6, s.query(3));
		s.removeNum(6);
		Assert.assertEquals(0, s.query(0));
		Assert.assertEquals(-1, s.query(1));
		Assert.assertEquals(-1, s.query(2));
		Assert.assertEquals(-1, s.query(4));
		s.removeNum(0);
	}
}
