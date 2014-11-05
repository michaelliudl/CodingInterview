package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 10/1/14.
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) return Collections.emptyList();
		List<Integer> result = new ArrayList<>(rowIndex + 1);
		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i - 1; j > 0; j--)
				result.set(j, result.get(j - 1) + result.get(j));
			result.add(1);
		}
		return result;
	}
}
