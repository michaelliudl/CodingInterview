package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 9/8/14.
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			result.add(new ArrayList<String>());
			return result;
		}
		int n = s.length();
		boolean[][] cache = new boolean[n][n];
		for (int i = 0; i < n; i++)
			cache[i][i] = true;
		List<String> path = new ArrayList<>();
		dfs(s, 0, path, result, cache);
		return result;
	}

	private void dfs(String s, int start, List<String> path, List<List<String>> result, boolean[][] cache) {
		if (start == s.length()) {
			List<String> copy = new ArrayList<>();
			for (String str : path)
				copy.add(str);
			result.add(copy);
		} else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindrome(s, start, i, cache)) {
					path.add(s.substring(start, i + 1));
					dfs(s, i + 1, path, result, cache);
					path.remove(path.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int start, int cur, boolean[][] cache) {
		if (start == cur)
			return true;
		if (s.charAt(start) == s.charAt(cur)) {
			if (cur - start == 1 || cache[start + 1][cur - 1]) {
				cache[start][cur] = true;
				return true;
			}
		}
		return false;
	}
}
