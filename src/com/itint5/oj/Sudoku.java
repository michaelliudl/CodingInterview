package com.itint5.oj;

/**
 * Created by doliu on 12/29/14.
 */
public class Sudoku {
	public boolean isValidSudoku(int[] arr) {
		if (arr == null || arr.length != 81) return false;
		for (int i = 0; i < arr.length; i += 9)
			if (!isValidRow(arr, i)) return false;
		for (int i = 0; i < 9; i++)
			if (!isValidCol(arr, i)) return false;
		for (int i = 0; i < arr.length; i += 27)
			for (int j = 0; j < 9; j += 3)
				if (!isValidSquare(arr, i + j)) return false;
		return true;
	}

	private boolean isValidSquare(int[] arr, int start) {
		boolean[] exist = new boolean[9];
		for (int i = start; i < start + 3; i++)
			for (int j = 0; j < 27; j += 9)
				if (!isValidValue(arr, i + j, exist)) return false;
		return true;
	}

	private boolean isValidValue(int[] arr, int pos, boolean[] exist) {
		int index = arr[pos] - 1;
		if (index < 0 || index >= 9 || exist[index]) return false;
		exist[index] = true;
		return true;
	}

	private boolean isValidCol(int[] arr, int start) {
		boolean[] exist = new boolean[9];
		for (int i = start; i < arr.length; i += 9)
			if (!isValidValue(arr, i, exist)) return false;
		return true;
	}

	private boolean isValidRow(int[] arr, int start) {
		boolean[] exist = new boolean[9];
		for (int i = start; i < start + 9; i++)
			if (!isValidValue(arr, i, exist)) return false;
		return true;
	}
}
