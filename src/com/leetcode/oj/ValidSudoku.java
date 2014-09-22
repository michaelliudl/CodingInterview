package com.leetcode.oj;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doliu on 9/12/14.
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null) return false;
		Set<Character> existing = new HashSet<>();
		int side = board.length;
		for (int i = 0; i < side; i++) {
			existing = new HashSet<>();
			for (int j = 0; j < side; j++) {
				if (existing.contains(board[i][j])) return false;
				else if (board[i][j] != '.') existing.add(board[i][j]);
			}
		}
		for (int j = 0; j < side; j++) {
			existing = new HashSet<>();
			for (int i = 0; i < side; i++) {
				if (existing.contains(board[i][j])) return false;
				else if (board[i][j] != '.') existing.add(board[i][j]);
			}
		}
		for (int i = 0; i < side; i += 3) {
			for (int j = 0; j < side; j += 3) {
				existing = new HashSet<>();
				for (int k = i; k < i + 3; k++) {
					for (int m = j; m < j + 3; m++) {
						if (existing.contains(board[k][m])) return false;
						else if (board[k][m] != '.') existing.add(board[k][m]);
					}
				}
			}
		}
		return true;
	}
}
