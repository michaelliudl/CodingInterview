package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/12/14.
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		if (num == null || num.length < 4) return Collections.emptyList();
		Arrays.sort(num);
		Set<List<Integer>> result = new HashSet<>();
		for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int k = j + 1, m = num.length - 1;
				while (k < m) {
					int sum = num[i] + num[j] + num[k] + num[m];
					if (sum == target) {
						result.add(Arrays.asList(num[i], num[j], num[k], num[m]));
						k++;
						m--;
					} else if (sum < target) k++;
					else m--;
				}
			}
		}
		return new ArrayList<>(result);
	}
}
