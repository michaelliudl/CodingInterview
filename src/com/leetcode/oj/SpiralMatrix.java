package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 9/17/14.
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return Collections.emptyList();
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = n - 1, target = m * n;
		List<Integer> result = new ArrayList<>();
		while (true) {
			for (int i = row; i <= col; i++) {
				result.add(matrix[row][i]);
				if (result.size() == target) return result;
			}
			for (int i = row + 1; i <= m - 1 - row; i++) {
				result.add(matrix[i][col]);
				if (result.size() == target) return result;
			}
			for (int i = col - 1; i >= n - 1 - col; i--) {
				result.add(matrix[m - 1 - row][i]);
				if (result.size() == target) return result;
			}
			for (int i = m - 2 - row; i >= row + 1; i--) {
				result.add(matrix[i][n - 1 - col]);
				if (result.size() == target) return result;
			}
			row++;
			col--;
		}
	}
}
