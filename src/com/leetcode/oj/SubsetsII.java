package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/22/14.
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		if (num == null || num.length == 0) return Arrays.asList(Collections.<Integer>emptyList());
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfsWithPath(num, 0, path, result);
		return result;
	}

	private void dfsWithPath(int[] num, int step, List<Integer> path, List<List<Integer>> result) {
		List<Integer> copy = new ArrayList<>();
		for (Integer i : path) copy.add(i);
		result.add(copy);
		for (int i = step; i < num.length; i++) {
			if (i > step && num[i] == num[i - 1]) continue;
			path.add(num[i]);
			dfsWithPath(num, i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}

	public List<List<Integer>> subsetsWithDupWithMap(int[] num) {
		if (num == null || num.length == 0) return Arrays.asList(Collections.<Integer>emptyList());
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : num)
			if (count.containsKey(i)) count.put(i, count.get(i) + 1);
			else count.put(i, 1);
		Set<Integer> set = new HashSet<>();
		for (int i : num) set.add(i);
		Integer[] temp = new Integer[set.size()];
		set.toArray(temp);
		int[] uniqueNum = new int[temp.length];
		for (int i = 0; i < temp.length; i++) uniqueNum[i] = temp[i];
		Arrays.sort(uniqueNum);
		dfsWithMap(uniqueNum, 0, path, result, count);
		return result;
	}

	private void dfsWithMap(int[] num, int step, List<Integer> path, List<List<Integer>> result, Map<Integer, Integer> count) {
		if (step == num.length) {
			List<Integer> copy = new ArrayList<>();
			for (Integer p : path) copy.add(p);
			result.add(copy);
		} else {
			for (int i = 0; i <= count.get(num[step]); i++) {
				for (int j = 0; j < i; j++)
					path.add(num[step]);
				dfsWithMap(num, step + 1, path, result, count);
				for (int j = 0; j < i; j++)
					path.remove(path.size() - 1);
			}
		}
	}

	public List<List<Integer>> subsetsWithDupIterative(int[] num) {
		if (num == null || num.length == 0) return Arrays.asList(Collections.<Integer>emptyList());
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		int prevSize = 0;
		for (int i = 0; i < num.length; i++) {
			int curSize = result.size();
			for (int j = 0; j < curSize; j++) {
				if (i == 0 || num[i] != num[i - 1] || j >= prevSize) {
					List<Integer> copy = new ArrayList<>();
					for (int e : result.get(j)) copy.add(e);
					copy.add(num[i]);
					result.add(copy);
				}
			}
			prevSize = curSize;
		}
		return result;
	}
}
