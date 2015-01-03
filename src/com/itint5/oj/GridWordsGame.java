package com.itint5.oj;

import java.util.*;
import java.util.Arrays;

/**
 * Created by doliu on 12/26/14.
 */
// 单词游戏
public class GridWordsGame {

	private List<Pair> steps = Arrays.asList(new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1));

	public boolean exists(char[][] grid, String pattern) {
		if (grid == null || grid[0] == null || pattern == null || pattern.isEmpty()) return false;
		int m = grid.length, n = grid[0].length;
		if (m * n < pattern.length()) return false;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid[i][j] == pattern.charAt(0)) {
					Set<Pair> picked = new HashSet<>();
					boolean found = exists(grid, i, j, pattern, 0, picked);
					if (found) return true;
				}
		return false;
	}

	private boolean exists(char[][] grid, int i, int j, String pattern, int depth, Set<Pair> picked) {
		if (grid[i][j] != pattern.charAt(depth)) return false;
		picked.add(new Pair(i, j));
		if (depth == pattern.length() - 1) return true;
		Set<Pair> next = findValidNext(grid, i, j, picked);
		boolean found = false;
		for (Pair pair : next) {
			found |= exists(grid, pair.i, pair.j, pattern, depth + 1, picked);
		}
		return found;
	}

	private Set<Pair> findValidNext(char[][] grid, int i, int j, Set<Pair> picked) {
		Set<Pair> pairs = new HashSet<>();
		Pair pair = new Pair(i, j);
		for (Pair step : steps) {
			Pair next = pair.move(step);
			if (next.isValid(grid.length, grid[0].length) && !picked.contains(next)) pairs.add(next);
		}
		return pairs;
	}

	final static class Pair {
		int i, j;
		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		boolean isValid(int m, int n) {
			return this.i >= 0 && this.i < m && this.j >= 0 && this.j < n;
		}

		Pair move(Pair step) {
			if (step == null) return this;
			return new Pair(this.i + step.i, this.j + step.j);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Pair pair = (Pair) o;

			if (i != pair.i) return false;
			if (j != pair.j) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result = i;
			result = 31 * result + j;
			return result;
		}
	}
}
