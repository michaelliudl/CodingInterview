package com.leetcode.oj;

/**
 * Created by doliu on 8/19/14.
 */
public class ReverseInteger {
	public int reverse(int x) {
		long result = 0;
		int num = x;
		if (x < 0) num = -x;
		while (num > 0) {
			int last = num % 10;
			result *= 10;
			result += last;
			num /= 10;
		}
		if (x < 0) result = -result;
		if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		return (int)result;
	}
}
