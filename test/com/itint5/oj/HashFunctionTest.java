package com.itint5.oj;

import org.junit.Test;

/**
 * Created by doliu on 12/12/14.
 */
public class HashFunctionTest {
	@Test
	public void testHashCode() {
		new HashFunction().hashCode("ubuntu".toCharArray(), 1007);
	}
}
