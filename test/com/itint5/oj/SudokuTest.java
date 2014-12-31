package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/29/14.
 */
public class SudokuTest {
	@Test
	public void testIsValidSudoku() {
		Assert.assertTrue(new Sudoku().isValidSudoku(new int[]{9, 5, 4, 7, 6, 1, 2, 8, 3, 1, 3, 6, 4, 8, 2, 9, 7, 5, 8, 2, 7, 9, 5, 3, 6, 1, 4, 6, 4, 2, 1, 3, 9, 8, 5, 7, 7, 1, 5, 6, 2, 8, 4, 3, 9, 3, 9, 8, 5, 4, 7, 1, 6, 2, 5, 6, 9, 3, 1, 4, 7, 2, 8, 4, 8, 3, 2, 7, 6, 5, 9, 1, 2, 7, 1, 8, 9, 5, 3, 4, 6}));
	}
}
