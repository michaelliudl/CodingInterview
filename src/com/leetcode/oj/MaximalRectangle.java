package com.leetcode.oj;

/**
 * Created by doliu on 9/29/14.
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int m = matrix.length, n = matrix[0].length, max = 0;
		int[] height = new int[n], left = new int[n], right = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = left[i] = 0;
			right[i] = n;
		}
		for (int i = 0; i < m; i++) {
			int curLeft = 0, curRight = n;
			// scan from left to right to find left edge of horizontal continuous '1's
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
					left[j] = Math.max(left[j], curLeft);
				} else {
					curLeft = j + 1;
					height[j] = left[j] = 0;
					right[j] = n;
				}
			}
			// scan from right to left to find right edge, when right most '1' is found, calculate largest rectangle so far
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], curRight);
					max = Math.max(max, height[j] * (right[j] - left[j]));
				} else curRight = j;
			}
		}
		return max;
	}
}
