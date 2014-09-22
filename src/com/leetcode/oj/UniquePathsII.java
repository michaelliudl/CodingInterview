package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 9/4/14.
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
		int[][] cache = new int[m][n];
		for (int j = 0; j < n; j++) {
			cache[0][j] = 1;
			if (obstacleGrid[0][j] == 1 || (j > 0 && cache[0][j - 1] == -1))
				cache[0][j] = -1;
		}
		for (int i = 0; i < m; i++) {
			cache[i][0] = 1;
			if (obstacleGrid[i][0] == 1 || (i > 0 && cache[i - 1][0] == -1))
				cache[i][0] = -1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) cache[i][j] = -1;
				else {
					if (cache[i - 1][j] > 0) cache[i][j] += cache[i - 1][j];
					if (cache[i][j - 1] > 0) cache[i][j] += cache[i][j - 1];
				}
			}
		}
		return cache[m - 1][n - 1];
	}
}
