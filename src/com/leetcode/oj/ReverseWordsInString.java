package com.leetcode.oj;

/**
 * Created by doliu on 5/7/14.
 */
public class ReverseWordsInString {
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		String[] split = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = split.length - 1; i >= 0; i--) {
			if (split[i].length() > 0) {
				sb.append(split[i]).append(" ");
			}
		}
		return sb.toString().trim();
	}
}
