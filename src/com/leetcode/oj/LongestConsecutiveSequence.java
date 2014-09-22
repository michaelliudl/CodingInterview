package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 9/11/14.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) return 0;
		Map<Integer, Boolean> items = new HashMap<>();
		for (int n : num) items.put(n, false);
		int max = 0;
		for (int n : num) {
			if (!items.get(n)) {
				int len = 1;
				int adj = n + 1;
				while (items.containsKey(adj) && !items.get(adj)) {
					len++;
					items.put(adj, true);
					adj++;
				}
				adj = n - 1;
				while (items.containsKey(adj) && !items.get(adj)) {
					len++;
					items.put(adj, true);
					adj--;
				}
				max = Math.max(max, len);
			}
		}
		return max;
	}
}
