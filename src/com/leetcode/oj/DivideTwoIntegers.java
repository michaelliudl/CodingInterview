package com.leetcode.oj;

/**
 * Created by doliu on 10/8/14.
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) throw new IllegalArgumentException();
		boolean isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
		long dd = Math.abs((long)dividend), dv = Math.abs((long)divisor), result = 0;
		while (dd > dv) {
			long temp = dv;
			for (int i = 0; dd > temp; i++, temp <<= 1) {
				dd -= temp;
				result += 1 << i;
			}
		}
		return (int)(isPositive ? result : -result);
	}
}
