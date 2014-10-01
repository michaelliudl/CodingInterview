package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 9/22/14.
 */
public class Subsets {
	public List<List<Integer>> subsetsRecursive(int[] S) {
		if (S == null || S.length == 0) return Arrays.asList(Collections.<Integer>emptyList());
		Arrays.sort(S);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		subsets(S, 0, path, result);
		return result;
	}

	private void subsets(int[] array, int step, List<Integer> path, List<List<Integer>> result) {
		if (step == array.length) {
			List<Integer> p = new ArrayList<>();
			for (int e : path) p.add(e);
			result.add(p);
		} else {
			subsets(array, step + 1, path, result); // don't choose S[step]
			path.add(array[step]);
			subsets(array, step + 1, path, result); // choose S[step], each step has 2 options, O(2^n)
			path.remove(path.size() - 1);
		}
	}

	public List<List<Integer>> subsetsRecursiveBitVector(int[] S) {
		if (S == null || S.length == 0) return Arrays.asList(Collections.<Integer>emptyList());
		Arrays.sort(S);
		List<List<Integer>> result = new ArrayList<>();
		boolean[] chosen = new boolean[S.length];
		subsets(S, 0, chosen, result);
		return result;
	}

	private void subsets(int[] array, int step, boolean[] chosen, List<List<Integer>> result) {
		if (step == array.length) {
			List<Integer> path = new ArrayList<>();
			for (int i = 0; i < array.length; i++)
				if (chosen[i]) path.add(array[i]);
			result.add(path);
		} else {
			chosen[step] = false;
			subsets(array, step + 1, chosen, result);
			chosen[step] = true;
			subsets(array, step + 1, chosen, result);
		}
	}

	public List<List<Integer>> subsetsIterativeBitVector(int[] S) {
		if (S == null || S.length == 0) return Arrays.asList(Collections.<Integer>emptyList());
		Arrays.sort(S);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		int n = S.length;
		for (int i = 0; i < (1 << n); i++) {
			for (int j = 0; j < n; j++)
				if ((i & (1 << j)) > 0) path.add(S[j]);
			List<Integer> copy = new ArrayList<>();
			for (Integer k : path) copy.add(k);
			result.add(copy);
			path.clear();
		}
		return result;
	}
}
