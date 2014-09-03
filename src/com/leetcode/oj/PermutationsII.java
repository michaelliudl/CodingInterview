package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 8/30/14.
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		if (num == null || num.length <= 0) return Collections.emptyList();
		return new ArrayList<>(permute(num, 0));
	}

	private Set<List<Integer>> permute(int[] num, int start) {
		if (start == num.length - 1) {
			Set<List<Integer>> result = new HashSet<>();
			List<Integer> element = new ArrayList<>();
			element.add(num[start]);
			result.add(element);
			return result;
		}
		Set<List<Integer>> subPerm = permute(num, start + 1);
		Set<List<Integer>> result = new HashSet<>();
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
