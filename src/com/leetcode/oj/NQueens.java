package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 8/25/14.
 */
public class NQueens {
	public List<String[]> solveNQueens(int n) {
		if (n <= 0) return Collections.emptyList();
		String[] singleQueen = new String[] {"Q"};
		if (n == 1) return Arrays.asList(new String[][] {singleQueen});
		int[] solution = new int[n];
		List<String[]> result = new ArrayList<>();
		dfs(solution, result, 0);
		return result;
	}

	private void dfs(int[] solution, List<String[]> result, int row) {
		int size = solution.length;
		if (row == size) {
			generateSolution(solution, result);
			return;
		}
		for (int col = 0; col < size; col++) {
			if (isColumnOk(solution, row, col)) {
				solution[row] = col;
				dfs(solution, result, row + 1);
			}
		}
	}

	private boolean isColumnOk(int[] solution, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (solution[i] == col) return false;
			if ((row - i) == Math.abs(col - solution[i])) return false;
		}
		return true;
	}

	private void generateSolution(int[] solution, List<String[]> result) {
		int size = solution.length;
		String[] strings = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < size; j++) {
				if (solution[i] == j) sb.append('Q');
				else sb.append('.');
			}
			strings[i] = sb.toString();
		}
		result.add(strings);
	}
}
