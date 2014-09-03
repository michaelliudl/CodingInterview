package com.leetcode.oj;

/**
 * Created by doliu on 8/25/14.
 */
public class NQueensII {
	public int totalNQueens(int n) {
		if (n <= 1) return n;
		int totalSolutions = 0;
		int[] columns = new int[n];
		int[] main_diag = new int[2 * n];
		int[] anti_diag = new int[2 * n];
		totalSolutions = dfs(columns, main_diag, anti_diag, 0, totalSolutions);
		return totalSolutions;
	}

	private int dfs(int[] columns, int[] main_diag, int[] anti_diag, int row, int totalSolutions) {
		int n = columns.length;
		if (row == n) return ++totalSolutions;
		for (int col = 0; col < n; col++) {
			if (canPlace(columns, main_diag, anti_diag, row, col)) {
				columns[col] = main_diag[row + col] = anti_diag[row - col + n] = 1;
				totalSolutions = dfs(columns, main_diag, anti_diag, row + 1, totalSolutions);
				columns[col] = main_diag[row + col] = anti_diag[row - col + n] = 0;
			}
		}
		return totalSolutions;
	}

	private boolean canPlace(int[] columns, int[] main_diag, int[] anti_diag, int row, int col) {
		int n = columns.length;
		return columns[col] == 0 && main_diag[row + col] == 0 && anti_diag[row - col + n] == 0;
	}
}
