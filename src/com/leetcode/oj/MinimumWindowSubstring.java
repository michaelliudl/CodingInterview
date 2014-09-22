package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 9/19/14.
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if (S == null || T == null || S.length() == 0) return S;
		if (T.length() == 0) return T;
		if (S.length() < T.length()) return "";
		int start = 0, end = 0, minStart = -1, minEnd = -1, curMin = Integer.MAX_VALUE;
		Map<Character, Integer> patternCount = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (patternCount.containsKey(c)) patternCount.put(c, patternCount.get(c) + 1);
			else patternCount.put(c, 1);
		}
		Map<Character, Integer> foundCount = new HashMap<>();
		for (; end < S.length(); end++) {
			char endChar = S.charAt(end);
			if (patternCount.containsKey(S.charAt(end))) {
				if (foundCount.containsKey(endChar)) foundCount.put(endChar, foundCount.get(endChar) + 1);
				else foundCount.put(endChar, 1);
			}
			if (allFound(patternCount, foundCount)) {
				for (; start <= end - T.length() + 1; start++) {
					char startChar = S.charAt(start);
					if (patternCount.containsKey(startChar)) {
						if (foundCount.get(startChar) > patternCount.get(startChar)) {
							foundCount.put(startChar, foundCount.get(startChar) - 1);
						} else {
							int len = end - start + 1;
							if (len < curMin) {
								curMin = len;
								minStart = start;
								minEnd = end;
							}
							break;
						}
					}
				}
				char startChar = S.charAt(start);
				if (foundCount.get(startChar) > 1) foundCount.put(startChar, foundCount.get(startChar) - 1);
				else foundCount.remove(startChar);
				start++;
			}
		}
		if (minStart >= 0 && minEnd >= minStart && minEnd < S.length()) return S.substring(minStart, minEnd + 1);
		return "";
	}

	private boolean allFound(Map<Character, Integer> pattern, Map<Character, Integer> found) {
		if (pattern.size() != found.size()) return false;
		for (Map.Entry<Character, Integer> entry : found.entrySet()) {
			if (entry.getValue() < pattern.get(entry.getKey())) return false;
		}
		return true;
	}

	public String minWindowBrute(String S, String T) {
		if (S == null || T == null || S.length() == 0) return S;
		if (T.length() == 0) return T;
		if (S.length() < T.length()) return "";
		String window = null;
		int start = 0, next = 0, end = 0, diff = S.length() - T.length(), foundCount = 0;
		while (start < diff) {
			if (!T.contains(String.valueOf(S.charAt(start)))) start++;
			end = start + 1;
			foundCount = 1;
			while (end < S.length() && foundCount < T.length()) {
				if (!T.contains(String.valueOf(S.charAt(start)))) end++;
				if (next == 0) next = end;
				if (++foundCount == T.length()) break;
				else end++;
			}
			if (foundCount < T.length()) return "";
			String span = end < S.length() ? S.substring(start, end + 1) : S.substring(start);
			if (window == null || window.length() > span.length()) window = span;
			if (next > 0) {
				start = next;
				next = 0;
				foundCount = 0;
			} else break;
		}
		return window == null ? "" : window;
	}
}
