package com.leetcode.oj;

/**
 * Created by doliu on 9/17/14.
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n <= 0) return new int[0][0];
		int[][] result = new int[n][n];
		int target = n * n, small = 0, large = n - 1;
		while (small <= large) {
			int start = small == 0 ? 1 : result[small][small - 1] + 1;
			for (int i = small; i < n - small; i++) {
				int value = start++;
				result[small][i] = value;
				if (value == target) return result;
			}
			for (int i = small + 1; i < n - small; i++) {
				int value = start++;
				result[i][large] = value;
				if (value == target) return result;
			}
			for (int i = large - 1; i >= small; i--) {
				int value = start++;
				result[large][i] = value;
				if (value == target) return result;
			}
			for (int i = large - 1; i > small; i--) {
				int value = start++;
				result[i][small] = value;
				if (value == target) return result;
			}
			small++;
			large--;
		}
		return result;
	}
}
