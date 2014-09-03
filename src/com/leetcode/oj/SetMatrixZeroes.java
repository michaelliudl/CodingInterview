package com.leetcode.oj;

/**
 * Created by doliu on 9/2/14.
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
		int rowCount = matrix.length, colCount = matrix[0].length;
		boolean[] rowHasZero = new boolean[rowCount], colHasZero = new boolean[colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				if (matrix[i][j] == 0) rowHasZero[i] = colHasZero[j] = true;
			}
		}
		for (int i = 0; i < rowCount; i++) {
			if (rowHasZero[i]) {
				for (int j = 0; j < colCount; j++) matrix[i][j] = 0;
			}
		}
		for (int j = 0; j < colCount; j++) {
			if (colHasZero[j]) {
				for (int i = 0; i < rowCount; i++) matrix[i][j] = 0;
			}
		}
	}

	public void setZeroesConstantSpace(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
		int rowCount = matrix.length, colCount = matrix[0].length;
		// remember if first row/column initially has zeroes
		boolean firstRowHasZero = false, firstColHasZero = false;
		for (int i = 0; i < rowCount; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}
		for (int j = 0; j < colCount; j++) {
			if (matrix[0][j] == 0) {
				firstRowHasZero = true;
				break;
			}
		}
		// scan submatrix excluding first row and column for 0
		// update first row column to 0 if found in submatrix
		for (int i = 1; i < rowCount; i++) {
			for (int j = 1; j < colCount; j++) {
				if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
			}
		}
		// update submatrix to 0 by scanning first row and column
		for (int i = 1; i < rowCount; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < colCount; j++) matrix[i][j] = 0;
			}
		}
		for (int j = 1; j < colCount; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < rowCount; i++) matrix[i][j] = 0;
			}
		}
		// update first row and column
		if (firstRowHasZero) {
			for (int j = 0; j < colCount; j++) matrix[0][j] = 0;
		}
		if (firstColHasZero) {
			for (int i = 0; i < rowCount; i++) matrix[i][0] = 0;
		}
	}
}
