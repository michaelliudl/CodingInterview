package com.leetcode.oj;

/**
 * Created by doliu on 8/20/14.
 */
public class UniqueBinarySearchTrees {
	/*
	f(i)=sum(f(k-1)*f(i-k)) where 2<=i<=n, 1<=k<=i
	DP
	 */
	public int numTrees(int n) {
		int[] values = new int[n + 1];
		values[0] = 1;
		values[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int k = 1; k <= i; k++) {
				values[i] += values[k - 1] * values[i - k];
			}
		}
		return values[n];
	}
}
