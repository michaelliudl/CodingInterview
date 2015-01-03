package com.itint5.oj;

/**
 * Created by doliu on 1/1/15.
 */
// 最大子矩阵和
public class MatrixMaxSumSubMatrix {
	public int maxRectSum(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int n = matrix.length, m = matrix[0].length, max = 0;
		// create range on columns, i = left bound, j = right bound
		for (int i = 0; i < m; i++) {
			int[] colSum = new int[n]; // column sum of each row from column i to column j
			for (int j = i; j < m; j++) {
				for (int k = 0; k < n; k++) {
					colSum[k] += matrix[k][j]; // sum each row from left to right
				}
				int sum = 0; // sum on rows after above sum on column ranges
				for (int k = 0; k < n; k++) {
					sum = Math.max(sum, 0);
					sum += colSum[k];
					max = Math.max(max, sum);
				}
			}
		}
		return max;
	}
}
