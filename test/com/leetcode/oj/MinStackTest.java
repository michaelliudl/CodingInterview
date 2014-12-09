package com.leetcode.oj;

import org.junit.Test;

/**
 * Created by doliu on 11/10/14.
 */
public class MinStackTest {
	@Test
	public void testMinStack() {
		MinStack ms = new MinStack();
		ms.push(2147483646);
		ms.push(2147483646);
		ms.push(2147483647);
		ms.top();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.push(2147483647);
		ms.top();
		ms.getMin();
		ms.push(-2147483648);
		ms.top();
		ms.getMin();
		ms.pop();
		ms.getMin();
	}
}
