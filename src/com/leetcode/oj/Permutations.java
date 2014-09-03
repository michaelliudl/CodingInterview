package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 8/29/14.
 */
public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		if (num == null || num.length <= 0) return Collections.emptyList();
		return permute(num, 0);
	}

	private List<List<Integer>> permute(int[] num, int start) {
		if (start == num.length - 1) {
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> element = new ArrayList<>();
			element.add(num[start]);
			result.add(element);
			return result;
		}
		List<List<Integer>> subPerm = permute(num, start + 1);
		List<List<Integer>> result = new ArrayList<>();
		for (List<Integer> perm : subPerm) {
			for (int i = 0; i <= perm.size(); i++) {
				List<Integer> newPerm = new ArrayList<>(perm.size() + 1);
				newPerm.addAll(perm);
				newPerm.add(i, num[start]);
				result.add(newPerm);
			}
		}
		return result;
	}
}
