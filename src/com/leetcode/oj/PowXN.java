package com.leetcode.oj;

/**
 * Created by doliu on 9/16/14.
 */
public class PowXN {
	public double pow(double x, int n) {
		int p = n < 0 ? -n : n;
		double result = powInternal(x, p);
		return n < 0 ? 1 / result : result;
	}

	private double powInternal(double x, int p) {
		if (p == 0) return 1;
		if (p == 1) return x;
		double halfPow = powInternal(x, p / 2);
		return (p & 0x1) == 1 ? x * halfPow * halfPow : halfPow * halfPow;
	}

	public double powBrute(double x, int n) {
		if (n == 0) return 1;
		int p = n < 0 ? -n : n;
		double result = 1;
		for (int i = p; i > 0; i--) {
			result *= x;
		}
		return n < 0 ? 1 / result : result;
	}
}
