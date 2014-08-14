package com.leetcode.oj;

/**
 * Created by doliu on 5/12/14.
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		int x = 1, y = 2;
		for (int i = 2; i < n; i++) {
			int temp = x;
			x = x + y;
			y = temp;
		}
		return x;
		//return climbStairs(n - 1) + climbStairs(n - 2);
	}
}
