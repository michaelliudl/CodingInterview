package com.leetcode.oj;

/**
 * Created by doliu on 10/3/14.
 */
public class CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) return "";
		String prev = "1";
		for (int i = 1; i < n; i++) {
			char curChar = prev.charAt(0);
			int prevPos = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= prev.length(); j++) {
				if (j == prev.length()) {
					int curCount = j - prevPos;
					sb.append(curCount).append(curChar);
				} else if (prev.charAt(j) != curChar) {
					sb.append(j - prevPos).append(curChar);
					prevPos = j;
					curChar = prev.charAt(j);
				}
			}
			prev = sb.toString();
		}
		return prev;
	}
}
