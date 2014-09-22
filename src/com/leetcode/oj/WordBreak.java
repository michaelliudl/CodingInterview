package com.leetcode.oj;

import java.util.Set;

/**
 * Created by doliu on 9/6/14.
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) return false;
		boolean[] canBreak = new boolean[s.length() + 1];
		canBreak[0] = true;
		for (int i = 1; i <= s.length(); i++) { // iterate over break indicators
			for (int j = i - 1; j >= 0; j--) { // if any prefix can break and corresponding postfix in dictionary, current substring can break
				if (canBreak[j] && dict.contains(s.substring(j, i))) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[s.length()];
	}

	// time out, O(n^3)
	public boolean wordBreakDFS(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) return false;
		return dfs(s, dict, 0, 0);
	}

	private boolean dfs(String s, Set<String> dict, int start, int cur) {
		if (cur == s.length()) return dict.contains(s.substring(start, cur));
		if (dfs(s, dict, start, cur + 1)) return true;
		if (dict.contains(s.substring(start, cur)))
			if (dfs(s, dict, cur, cur)) return true;
		return false;
	}
}
