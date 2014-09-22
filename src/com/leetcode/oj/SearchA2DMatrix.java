package com.leetcode.oj;

/**
 * Created by doliu on 9/14/14.
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int m = matrix.length, n = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
		int start = 0, end = m * n - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			int value = matrix[mid / n][mid % n];
			if (target == value) return true;
			else if (target < value) end = mid - 1;
			else start = mid + 1;
		}
		if (start == end) return target == matrix[start / n][start % n];
		return false;
	}
	public boolean searchMatrixRowColumnSeparate(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int m = matrix.length, n = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
		int start = 0, end = m - 1, row = -1;
		while (start <= end) {
			if (start == end) {
				if (target >= matrix[start][0] || target <= matrix[start][n - 1]) {
					row = start;
					break;
				} else return false;
			}
			int mid = (start + end) / 2;
			if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
				row = mid;
				break;
			} else if (target < matrix[mid][0]) end = mid - 1;
			else start = mid + 1;
		}
		if (row < 0) return false;
		start = 0;
		end = n - 1;
		while (start <= end) {
			if (start == end) return target == matrix[row][start];
			int mid = (start + end) / 2;
			if (target == matrix[row][mid]) return true;
			else if (target < matrix[row][mid]) end = mid - 1;
			else start = mid + 1;
		}
		return false;
	}
}
