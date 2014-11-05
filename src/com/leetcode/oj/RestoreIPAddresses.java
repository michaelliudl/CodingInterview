package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 10/3/14.
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		if (s == null || s.length() < 4 || s.length() > 12) return Collections.emptyList();
		List<String> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		dfs(s, 0, path, result);
		return result;
	}

	private void dfs(String s, int start, List<String> path, List<String> result) {
		if (path.size() == 4) {
			if (start == s.length()) {
				StringBuilder sb = new StringBuilder(path.get(0));
				for (int i = 1; i < path.size(); i++)
					sb.append(".").append(path.get(i));
				result.add(sb.toString());
			}
			return;
		}
		for (int i = start; i < s.length(); i++) {
			int remainingLen = s.length() - start;
			int maxValidLen = (4 - path.size()) * 3;
			if (remainingLen > maxValidLen)
				break;
			String sub = s.substring(start, i + 1);
			int digit = Integer.parseInt(sub);
			if (digit > 255 || (digit > 0 && sub.startsWith("0")) || (digit == 0 && sub.length() > 1))
				break;
			path.add(sub);
			dfs(s, i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}
}
