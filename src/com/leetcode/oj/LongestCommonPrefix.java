package com.leetcode.oj;

/**
 * Created by doliu on 9/14/14.
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		int shortest = Integer.MAX_VALUE;
		for (String s : strs) {
			if (s == null) return "";
			shortest = s.length() < shortest ? s.length() : shortest;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < shortest; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) return sb.toString();
			}
			sb.append(c);
		}
		return sb.toString();
	}
}
