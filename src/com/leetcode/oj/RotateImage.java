package com.leetcode.oj;

/**
 * Created by doliu on 9/13/14.
 */
public class RotateImage {
	// flip by anti-diagonal first, then flip by vertical middle
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) return;
		int side = matrix.length;
		// flip by anti-diagonal
		for (int i = 0; i < side - 1; i++) {
			for (int j = 0; j < side - 1 - i; j++) {
				swap(matrix, i, j, side - 1 - j, side - 1 - i);
			}
		}
		// flip by vertical middle
		for (int i = 0; i < side / 2; i++) {
			for (int j = 0; j < side; j++) {
				swap(matrix, i, j, side - 1 - i, j);
			}
		}
	}

	// flip by vertical middle first, then flip by main diagonal
	public void rotateAnother(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) return;
		int side = matrix.length;
		// flip by vertical middle
		for (int i = 0; i < side / 2; i++) {
			for (int j = 0; j < side; j++) {
				swap(matrix, i, j, side - 1 - i, j);
			}
		}
		// flip by main diagonal
		for (int i = 0; i < side - 1; i++) {
			for (int j = i + 1; j < side; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}

	private void swap(int[][] matrix, int i, int j, int m, int n) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[m][n];
		matrix[m][n] = temp;
	}
}
