package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/30/14.
 */
public class GridWordsGameTest {
	@Test
	public void testExists() {
		char[][] grid = new char[3][];
		grid[0] = "PACD".toCharArray();
		grid[1] = "BGHI".toCharArray();
		grid[2] = "MNDC".toCharArray();
		Assert.assertTrue(new GridWordsGame().exists(grid, "DCHGB"));
		Assert.assertTrue(new GridWordsGame().exists(grid, "PBGNDC"));
		Assert.assertFalse(new GridWordsGame().exists(grid, "CIDCB"));
	}
}
