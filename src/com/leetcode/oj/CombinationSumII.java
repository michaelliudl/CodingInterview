package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 10/2/14.
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if (num == null || num.length == 0 || target <= 0) return Collections.emptyList();
		Arrays.sort(num);
		Set<List<Integer>> result = new HashSet<>();
		Deque<Integer> path = new ArrayDeque<>();
		dfs(num, target, 0, path, result);
		return new ArrayList<>(result);
	}

	private void dfs(int[] candidates, int gap, int start, Deque<Integer> path, Set<List<Integer>> result) {
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
				dfs(candidates, gap - candidates[i], i + 1, path, result);
				path.pop();
			}
		}
	}
}
