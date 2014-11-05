package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 10/2/14.
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0 || target <= 0) return Collections.emptyList();
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		dfs(candidates, target, 0, path, result);
		return result;
	}

	private void dfs(int[] candidates, int gap, int start, Deque<Integer> path, List<List<Integer>> result) {
		if (gap == 0) {
			List<Integer> curPath = new ArrayList<>();
			Iterator<Integer> iter = path.descendingIterator();
			while (iter.hasNext())
				curPath.add(iter.next());
			result.add(curPath);
		} else {
			for (int i = start; i < candidates.length; i++) {
				if (gap < candidates[i]) return;
				path.push(candidates[i]);
				dfs(candidates, gap - candidates[i], i, path, result);
				path.pop();
			}
		}
	}
}
