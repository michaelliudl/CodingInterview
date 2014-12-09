package com.leetcode.oj;

/**
 * Created by doliu on 10/8/14.
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int curS, String p, int curP) {
		if (curP == p.length()) return curS == s.length();
		if (curP == p.length() - 1) {
			if (curS >= s.length()) return false;
			if (p.charAt(curP) == s.charAt(curS) || p.charAt(curP) == '.')
				return isMatch(s, curS + 1, p, curP + 1);
			else return false;
		}
		if (p.charAt(curP + 1) != '*') {
			if (curS < s.length() && (p.charAt(curP) == s.charAt(curS) || p.charAt(curP) == '.'))
				return isMatch(s, curS + 1, p, curP + 1);
			else return false;
		} else {
			while (curS < s.length() && (p.charAt(curP) == s.charAt(curS) || p.charAt(curP) == '.')) {
				if (isMatch(s, curS, p, curP + 2))
					return true;
				curS++;
			}
			return isMatch(s, curS, p, curP + 2);
		}
	}
}
