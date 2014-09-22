package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by doliu on 9/7/14.
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) return Collections.emptyList();
		boolean[] canBreak = new boolean[s.length() + 1];
		canBreak[0] = true;
		boolean[][] breaks = new boolean[s.length() + 1][s.length()]; // breaks[i][j] = true means s.substring(j, i) is in dictionary
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (canBreak[j] && dict.contains(s.substring(j, i))) {
					canBreak[i] = true;
					breaks[i][j] = true; // find all possibilities
				}
			}
		}
		List<String> result = new ArrayList<>();
		if (canBreak[s.length()]) {
			List<String> line = new ArrayList<>();
			dfs(s, breaks, s.length(), line, result);
		}
		return result;
	}

	private void dfs(String s, boolean[][] breaks, int cur, List<String> line, List<String> result) {
		if (cur == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = line.size() - 1; i >= 0; i--) {
				sb.append(line.get(i)).append(" ");
			}
			result.add(sb.toString().trim());
		}
		for (int j = 0; j < s.length(); j++) {
			if (breaks[cur][j]) {
				line.add(s.substring(j, cur));
				dfs(s, breaks, j, line, result);
				line.remove(line.size() - 1);
			}
		}
	}
}
