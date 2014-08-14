package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 5/7/14.
 */
public class SingleNumberII {
	public int singleNumberNoExtraMemory(int[] A) {
		if (A == null) return Integer.MIN_VALUE;
		Arrays.sort(A);
		for (int i = 0, n = A.length; i < n; i += 3) {
			if (i == n - 1) return A[i];
			if (A[i] != A[i + 1]) {
				return A[i];
			}
		}
		return Integer.MIN_VALUE;
	}
}
