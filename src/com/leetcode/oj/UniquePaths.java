package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 9/4/14.
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0) return 0;
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) paths[i][0] = 1;
		for (int j = 0; j < n; j++) paths[0][j] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}
		return paths[m - 1][n - 1];
	}

	public int uniquePathsOneDimensionCache(int m, int n) {
		if (m <= 0 || n <= 0) return 0;
		int[] row = new int[n];
		Arrays.fill(row, 1);
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				row[j] = row[j - 1] + row[j];
		return row[n - 1];
	}

	public int uniquePathsMemoization(int m, int n) {
		if (m <= 0 || n <= 0) return 0;
		int[][] cache = new int[m][n];
		cache[0][0] = 1;
		dfs(m - 1, n - 1, cache);
		return cache[m - 1][n - 1];
	}

	private void dfs(int m, int n, int[][] cache) {
		if (m < 0 || n < 0) return;
		if (m == 0 && n == 0) return;
		cache[m][n] = getOrUpdate(m - 1, n, cache)
				+ getOrUpdate(m, n - 1, cache);
	}

	private int getOrUpdate(int m, int n, int[][] cache) {
		if (m < 0 || n < 0) return 0;
		if (cache[m][n] > 0) return cache[m][n];
		dfs(m, n, cache);
		return cache[m][n];
	}
}
