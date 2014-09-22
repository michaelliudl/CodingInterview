package com.leetcode.oj;

import java.util.List;

/**
 * Created by doliu on 9/7/14.
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) return -1;
		if (triangle.size() == 1 && triangle.get(0) != null && triangle.get(0).size() > 0) return triangle.get(0).get(0);
		for (int row = triangle.size() - 2; row >= 0; row--) {
			for (int col = 0; col < triangle.get(row).size(); col++) {
				int value = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1))
						+ triangle.get(row).get(col);
				triangle.get(row).set(col, value);
			}
		}
		return triangle.get(0).get(0);
	}
}
