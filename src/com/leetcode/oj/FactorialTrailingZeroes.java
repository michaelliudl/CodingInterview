package com.leetcode.oj;

/**
 * Created by doliu on 1/7/15.
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		if (n <= 0) return 0;
		int count = 0, start = 5, cur = n;
		while (cur > 0) {
			cur = n / start;
			count += cur;
			start *= 5;
		}
		return count;
	}
}
