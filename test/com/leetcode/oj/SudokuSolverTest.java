package com.leetcode.oj;

import org.junit.Test;

/**
 * Created by doliu on 10/6/14.
 */
public class SudokuSolverTest {
	@Test
	public void testSolveSudoku() {
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				board[i][j] = '.';
		board[0][2] ='9';
		board[0][3] ='7';
		board[0][4] ='4';
		board[0][5] ='8';
		board[1][0] ='7';
		board[2][1] ='2';
		board[2][3] ='1';
		board[2][5] ='9';
		board[3][2] ='7';
		board[3][6] ='2';
		board[3][7] ='4';
		board[4][1] ='6';
		board[4][2] ='4';
		board[4][4] ='1';
		board[4][6] ='5';
		board[4][7] ='9';
		board[5][1] ='9';
		board[5][2] ='8';
		board[5][6] ='3';
		board[6][3] ='8';
		board[6][5] ='3';
		board[6][7] ='2';
		board[7][8] ='6';
		board[8][3] ='2';
		board[8][4] ='7';
		board[8][5] ='5';
		board[8][6] ='9';

		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(board);
	}
}
