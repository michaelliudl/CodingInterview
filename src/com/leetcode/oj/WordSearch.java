package com.leetcode.oj;

/**
 * Created by doliu on 10/1/14.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) return false;
		int m = board.length, n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0, visited))
					return true;
		return false;
	}

	private boolean dfs(char[][] board, int r, int c, String word, int p, boolean[][] visited) {
		if (p == word.length()) return true;
		int m = board.length, n = board[0].length;
		if (r < 0 || r >= m || c < 0 || c >= n) return false;
		if (!visited[r][c] && board[r][c] == word.charAt(p)) {
			visited[r][c] = true;
			boolean next = dfs(board, r - 1, c, word, p + 1, visited)
					|| dfs(board, r + 1, c, word, p + 1, visited)
					|| dfs(board, r, c - 1, word, p + 1, visited)
					|| dfs(board, r, c + 1, word, p + 1, visited);
			visited[r][c] = false;
			return next;
		}
		return false;
	}
}
