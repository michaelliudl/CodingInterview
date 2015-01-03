package com.itint5.oj;

/**
 * Created by doliu on 12/31/14.
 */
// 棋盘漫步
public class GridRobot {
	public int totalPath(boolean[][] blocked) {
		if (blocked == null || blocked.length == 0) return 0;
		int n = blocked.length, m = blocked[0].length;
		int[][] cache = new int[n][m];
		cache[0][0] = 1;
		for (int j = 1; j < m; j++)
			cache[0][j] = blocked[0][j] ? 0 : cache[0][j - 1];
		for (int i = 1; i < n; i++)
			cache[i][0] = blocked[i][0] ? 0 : cache[i - 1][0];
		for (int i = 1; i < n; i++)
			for (int j = 1; j < m; j++)
				cache[i][j] = blocked[i][j] ? 0 : cache[i - 1][j] + cache[i][j - 1];
		return cache[n - 1][m - 1];
	}
}
