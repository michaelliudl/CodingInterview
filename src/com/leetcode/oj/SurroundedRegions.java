package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/19/14.
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) return;
		Set<Pair> noCapture = new HashSet<>();
		List<Pair> sideOpen = new ArrayList<>();
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') sideOpen.add(new Pair(i, 0));
			if (board[i][n - 1] == 'O') sideOpen.add(new Pair(i, n - 1));
		}
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O') sideOpen.add(new Pair(0, j));
			if (board[m - 1][j] == 'O') sideOpen.add(new Pair(m - 1, j));
		}
		for (Pair open : sideOpen) {
			if (noCapture.contains(open)) continue;
			Deque<Pair> stack = new ArrayDeque<>();
			stack.push(open);
			while (!stack.isEmpty()) {
				Pair p = stack.pop();
				noCapture.add(p);
				if (p.x - 1 >= 0 && board[p.x - 1][p.y] == 'O') {
					Pair neighbor = new Pair(p.x - 1, p.y);
					if (!noCapture.contains(neighbor)) stack.push(neighbor);
				}
				if (p.x + 1 < m && board[p.x + 1][p.y] == 'O') {
					Pair neighbor = new Pair(p.x + 1, p.y);
					if (!noCapture.contains(neighbor)) stack.push(neighbor);
				}
				if (p.y - 1 >= 0 && board[p.x][p.y - 1] == 'O') {
					Pair neighbor = new Pair(p.x, p.y - 1);
					if (!noCapture.contains(neighbor)) stack.push(neighbor);
				}
				if (p.y + 1 < n && board[p.x][p.y + 1] == 'O') {
					Pair neighbor = new Pair(p.x, p.y + 1);
					if (!noCapture.contains(neighbor)) stack.push(neighbor);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					Pair cur = new Pair(i, j);
					if (!noCapture.contains(cur)) {
						board[i][j] = 'X';
					}
				}
			}
		}
	}

	class Pair {
		public int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Pair pair = (Pair) o;

			if (x != pair.x) return false;
			if (y != pair.y) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = x;
			result = 31 * result + y;
			return result;
		}
	}
}
