package com.itint5.oj;

import com.lintcode.oj.HashFunction;
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
