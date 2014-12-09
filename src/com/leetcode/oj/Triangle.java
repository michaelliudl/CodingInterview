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

	public int minimumTotalDP(List<List<Integer>> triangle) {
		int n = triangle.size(), max = triangle.get(n - 1).size();
		int[] sum = new int[max];
		for (int i = n - 1; i >= 0; i--) {
			int len = triangle.get(i).size();
			for (int j = 0; j < len; j++) {
				if (i == n - 1)
					sum[j] = triangle.get(i).get(j);
				else {
					int cur = triangle.get(i).get(j);
					sum[j] = cur + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				}
			}
		}
		return sum[0];
	}
}
