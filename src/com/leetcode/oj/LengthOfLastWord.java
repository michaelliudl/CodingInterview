package com.leetcode.oj;

/**
 * Created by doliu on 5/13/14.
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int len = s.length(), lastChar = -1;
		int i = len - 1;
		for (; i >= 0; i--) {
			if (s.charAt(i) != ' ' && lastChar < 0) {
				lastChar = i;
			} else if (s.charAt(i) == ' ' && lastChar >= 0) {
				return lastChar - i;
			}
		}
		if (lastChar >= 0) {
			return lastChar - i;
		}
		return 0;
	}
}
