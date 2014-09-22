package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 9/20/14.
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		if (n <= 0 || k <= 0) return Collections.emptyList();
		return combine(n, k, 1);
	}

	private List<List<Integer>> combine(int n, int k, int start) {
		if (k == 0) return Arrays.asList(Collections.<Integer>emptyList());
		if (n == start + k - 1) {
			List<Integer> list = new ArrayList<>();
			for (int i = start; i <= n; i++) list.add(i);
			return Arrays.asList(list);
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = start; i <= n - k + 1; i++) {
			List<List<Integer>> subCombination = combine(n, k - 1, i + 1);
			for (List<Integer> sub : subCombination) {
				List<Integer> cur = new ArrayList<>();
				cur.add(i);
				cur.addAll(sub);
				result.add(cur);
			}
		}
		return result;
	}
}
