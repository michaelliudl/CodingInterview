package com.leetcode.oj;

/**
 * Created by doliu on 5/12/14.
 */
public class ClimbingStairs {
	/**
	 * f(n) = f(n-1) + f(n-2)
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n <= 1) return 1;
		int a = 1, b = 1, index = 1;
		while (index++ < n) {
			int temp = a;
			a = a + b;
			b = temp;
		}
		return a;
	}
}
