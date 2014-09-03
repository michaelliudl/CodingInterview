package com.leetcode.oj;

/**
 * Created by doliu on 9/2/14.
 */
public class MinimumPathSum {
	// 2 dimension dynamic programming
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
		int rowCount = grid.length, colCount = grid[0].length;
		int[][] minSum = new int[rowCount][colCount];
		minSum[0][0] = grid[0][0];
		for (int i = 1; i < rowCount; i++) {
			minSum[i][0] = minSum[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < colCount; j++) {
			minSum[0][j] = minSum[0][j - 1] + grid[0][j];
		}
		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < colCount; j++) {
				minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
			}
		}
		return minSum[rowCount - 1][colCount - 1];
	}

	public int minPathSumOneDimensionArray(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
		int rowCount = grid.length, colCount = grid[0].length;
		int[] sumByRow = new int[colCount];
		for (int j = 1; j < colCount; j++) {
			sumByRow[j] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < rowCount; i++) {
			sumByRow[0] += grid[i][0];
			for (int j = 1; j < colCount; j++) {
				sumByRow[j] = Math.min(sumByRow[j - 1], sumByRow[j]) + grid[i][j];
			}
		}
		return sumByRow[colCount - 1];
	}

	public int minPathSumMemoization(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
		int rowCount = grid.length, colCount = grid[0].length;
		int[][] sumFromEnd = new int[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				sumFromEnd[i][j] = Integer.MIN_VALUE;
			}
		}
		return dfs(grid, rowCount - 1, colCount - 1, sumFromEnd);
	}

	private int dfs(int[][] grid, int row, int col, int[][] sum) {
		if (row < 0 || col < 0) return Integer.MAX_VALUE;
		if (row == 0 && col == 0) return grid[0][0];
		return Math.min(getOrPutCache(grid, row - 1, col, sum), getOrPutCache(grid, row, col - 1, sum)) + grid[row][col];
	}

	private int getOrPutCache(int[][] grid, int row, int col, int[][] sum) {
		if (row < 0 || col < 0) return Integer.MAX_VALUE;
		if (sum[row][col] > 0) return sum[row][col];
		int result = dfs(grid, row, col, sum);
		sum[row][col] = result;
		return result;
	}
}
