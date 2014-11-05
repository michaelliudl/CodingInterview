package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 10/6/14.
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		int len = 9;
		if (board == null || board.length != len || board[0].length != len) return;
		solveSudoku(board, 0, 0);
	}

	private boolean solveSudoku(char[][] board, int row, int col) {
		int len = 9;
		if (col >= len)
			return solveSudoku(board, row + 1, 0);
		if (row == len)
			return true;
		if (board[row][col] == '.') {
			for (int k = 0; k < len; k++) {
				board[row][col] = (char)('1' + k);
				if (isValid(board, row, col)) {
					if (solveSudoku(board, row, col + 1))
						return true;
				}
				board[row][col] = '.';
			}
		} else {
			return solveSudoku(board, row, col + 1);
		}
		return false;
	}

	private boolean isValid(char[][] board, int row, int col) {
		int len = 9, sub = 3;
		for (int i = 0; i < len; i++) {
			if (i != row && board[i][col] == board[row][col])
				return false;
			if (i != col && board[row][i] == board[row][col])
				return false;
		}
		int subRow = row < 3 ? 0 : (row < 6 ? 3 : 6);
		int subCol = col < 3 ? 0 : (col < 6 ? 3 : 6);
		for (int i = subRow; i < subRow + sub; i++)
			for (int j = subCol; j < subCol + sub; j++)
				if (board[i][j] == board[row][col] && !(i == row && j == col))
					return false;
		return true;
	}

}
